package com.example.tiendavivapets.data.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Comunas",
    foreignKeys = [
        ForeignKey(
            entity = Region::class,
            parentColumns = ["id"],
            childColumns = ["regionid"],
            onDelete = ForeignKey.RESTRICT // elimina productos si se borra la categoría
        )
    ]

)

class Comuna (
    @PrimaryKey
    val id: Int,
    @ColumnInfo(index = true)// crea un indice, para optimizar las querys
    val regionid: Int,
    val nombre: String
)