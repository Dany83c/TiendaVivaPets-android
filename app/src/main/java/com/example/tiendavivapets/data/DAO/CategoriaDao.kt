package com.example.tiendavivapets.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tiendavivapets.data.modelo.Categoria

@Dao
interface CategoriaDao {
    @Insert
    suspend fun insertar(categoria: Categoria)

    @Query("SELECT * FROM categorias")
    suspend fun getAll(): List<Categoria>

}