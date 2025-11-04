package com.example.tiendavivapets.data.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuarios")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val email: String,
    val nombre: String,
    val contrasena: String,
    val telefono: String?=null,
    val regionid: Int,
    val comunaid: Int


)