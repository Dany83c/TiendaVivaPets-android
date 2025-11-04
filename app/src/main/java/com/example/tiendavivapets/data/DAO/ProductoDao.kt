package com.example.tiendavivapets.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tiendavivapets.data.modelo.Producto

@Dao
interface  ProductoDao {
    @Insert
    suspend fun insertar(producto: Producto)

    @Query("SELECT * FROM productos")
    suspend fun getAll(): List<Producto>

    @Query("SELECT * FROM productos where id = :productoid")
    suspend fun getFromId(productoid: Int): List<Producto>

    @Query("SELECT * FROM productos WHERE categoriaId = :idCategoria")
    suspend fun obtenerPorCategoria(idCategoria: Int): List<Producto>

}