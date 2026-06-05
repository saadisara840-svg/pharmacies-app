package com.example.tpdesynthseroom.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tpdesynthseroom.model.Pharmacie

@Dao
interface PharmacieDao {

    @Query("SELECT * FROM pharmacies")
    suspend fun getAll(): List<Pharmacie>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertAll(list: List<Pharmacie>)

    @Query("DELETE FROM pharmacies")
    suspend fun deleteAll()
}