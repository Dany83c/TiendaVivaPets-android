package com.example.tiendavivapets.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tiendavivapets.data.modelo.Carrito


@Dao
interface CarritoDao {
    @Insert
    suspend fun insertar(carrito: Carrito)

    @Query("SELECT * FROM carrito")
    suspend fun getAll(): List<Carrito>

    @Query("SELECT * FROM carrito where id = :carritoid")
    suspend fun getFromId(carritoid: Int): List<Carrito>
}