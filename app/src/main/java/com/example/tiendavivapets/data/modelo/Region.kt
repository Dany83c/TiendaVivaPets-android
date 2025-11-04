package com.example.tiendavivapets.data.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Regiones")
data class Region(
    @PrimaryKey
    val id: Int,
    val nombre: String
)