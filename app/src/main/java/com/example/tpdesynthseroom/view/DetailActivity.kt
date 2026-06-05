package com.example.tpdesynthseroom.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tpdesynthseroom.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = findViewById<TextView>(R.id.tvName)
        val address = findViewById<TextView>(R.id.tvAddress)
        val phone = findViewById<TextView>(R.id.tvPhone)

        name.text = intent.getStringExtra("name")
        address.text = intent.getStringExtra("address")
        phone.text = intent.getStringExtra("phone")
    }
}