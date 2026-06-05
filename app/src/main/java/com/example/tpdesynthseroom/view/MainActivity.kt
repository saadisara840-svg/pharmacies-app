package com.example.tpdesynthseroom.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tpdesynthseroom.R
import com.example.tpdesynthseroom.adapter.AdapterPharmacie
import com.example.tpdesynthseroom.utils.SessionManager
import com.example.tpdesynthseroom.viewModel.PharmacieViewModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private val viewModel: PharmacieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val tvOffline = findViewById<TextView>(R.id.tvOffline)

        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.pharmacies.observe(this) { list ->
            recyclerView.adapter = AdapterPharmacie(list) { pharm ->
                val intent = Intent(this, DetailActivity::class.java)

                intent.putExtra("name", pharm.name)
                intent.putExtra("address", pharm.address)
                intent.putExtra("phone", pharm.phone)

                startActivity(intent)
            }
        }

        viewModel.isOffline.observe(this) { offline ->
            tvOffline.visibility = if (offline) View.VISIBLE else View.GONE
        }
        viewModel.isLoading.observe(this) { loading ->
            progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        }

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Pharmacies de Garde"

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.app_name,
            R.string.app_name
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_home -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_logout -> {
                    SessionManager(this).logout()

                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                    true
                }

                else -> false
            }
        }
    }
}