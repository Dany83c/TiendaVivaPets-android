package com.example.tiendavivapets.data.modelo
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey



@Entity(tableName = "Carrito",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id"],
            childColumns = ["userid"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Carrito (
     @PrimaryKey(autoGenerate = true)
     val id: Int,
     @ColumnInfo(index = true)
    val userid: Int,
    val items: List<CarritoItem>,
    val total: Double


     )