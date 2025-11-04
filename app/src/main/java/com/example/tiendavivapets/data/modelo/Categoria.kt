package com.example.tiendavivapets.data.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Categorias", )
data class Categoria (
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val nombre: String,

)