package com.example.tiendavivapets.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tiendavivapets.data.modelo.Region

@Dao
interface  RegionDao {
    @Insert
    suspend fun insertar(region: Region)

    @Query("SELECT * FROM regiones")
    suspend fun getAll(): List<Region>
}