package com.example.tiendavivapets.data.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "Productos",
    foreignKeys = [
        ForeignKey(
            entity = Categoria::class,
            parentColumns = ["id"],
            childColumns = ["categoriaid"],
            onDelete = ForeignKey.RESTRICT // restringe que se borre la categoria si existen productos con ella
        )
    ])
data class Producto (
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    @ColumnInfo(index = true)
    val categoriaid: Int,
    val nombre: String,
    val precio: Double,
    val descripcion: String= "",
    val imagenUrl: String?=null,
    val stock: Int


    )