package com.example.tpdesynthseroom.service

import com.example.tpdesynthseroom.model.Pharmacie
import retrofit2.http.*

interface ApiService {

    @GET("Pharmacies")
    suspend fun getPharmacies(): List<Pharmacie>
}