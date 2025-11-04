package com.example.tiendavivapets.data.DAO
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tiendavivapets.data.modelo.CarritoItem

@Dao
interface  CarritoItemDao {
    @Insert
    suspend fun insertar(carritoItem: CarritoItem)

    @Query("SELECT * FROM Carrito_item")
    suspend fun getAll(): List<CarritoItem>

    //borrar all the carrito
    @Query("DELETE FROM Carrito_item")
    suspend fun deleteAll()


}