package com.example.tpdesynthseroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pharmacies")
data class Pharmacie(
    @PrimaryKey val id: String,
    val name: String,
    val address: String,
    val phone: String
)


