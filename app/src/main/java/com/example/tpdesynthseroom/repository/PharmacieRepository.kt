package com.example.tpdesynthseroom.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.tpdesynthseroom.local.AppDatabase
import com.example.tpdesynthseroom.model.Pharmacie
import com.example.tpdesynthseroom.service.RetrofitPharmacie

class PharmacieRepository(private val context: Context) {

    private val dao = AppDatabase.getInstance(context).pharmacieDao()
    private val api = RetrofitPharmacie.instance

    suspend fun getPharmacie(): List<Pharmacie> {
        return if (isConnected()) {
            try {
                val liste = api.getPharmacies()
                dao.deleteAll()
                dao.insertAll(liste)
                liste
            } catch (e: Exception) {
                dao.getAll()
            }
        } else {
            dao.getAll()
        }
    }

    fun isConnectedPublic(): Boolean = isConnected()

    private fun isConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val cap = cm.getNetworkCapabilities(cm.activeNetwork) ?: return false
        return cap.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}