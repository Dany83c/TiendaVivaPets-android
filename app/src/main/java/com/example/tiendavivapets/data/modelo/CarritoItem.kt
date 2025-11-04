package com.example.tiendavivapets.data.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "Carrito_item",
    foreignKeys = [
        ForeignKey(
            entity = Producto::class,
            parentColumns = ["id"],
            childColumns = ["productoId"],
            onDelete = ForeignKey.RESTRICT
        )
    ])
data class CarritoItem (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(index = true)// crea un indice, para optimizar las querys
    val productoId: Int,
    val nombre: String,
    val precio: Double,
    val cantidad: Int,
    val imagenUrl: String?=null
)