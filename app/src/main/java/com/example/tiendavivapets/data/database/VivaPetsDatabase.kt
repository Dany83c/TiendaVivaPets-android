package com.example.tiendavivapets.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tiendavivapets.data.DAO.CarritoDao
import com.example.tiendavivapets.data.DAO.CarritoItemDao
import com.example.tiendavivapets.data.DAO.CategoriaDao
import com.example.tiendavivapets.data.DAO.ComunaDao
import com.example.tiendavivapets.data.DAO.ProductoDao
import com.example.tiendavivapets.data.DAO.RegionDao
import com.example.tiendavivapets.data.DAO.UsuarioDao
import com.example.tiendavivapets.data.modelo.Carrito
import com.example.tiendavivapets.data.modelo.CarritoItem
import com.example.tiendavivapets.data.modelo.Categoria
import com.example.tiendavivapets.data.modelo.Comuna
import com.example.tiendavivapets.data.modelo.Producto
import com.example.tiendavivapets.data.modelo.Region
import com.example.tiendavivapets.data.modelo.Usuario
import com.example.tiendavivapets.data.typeConverter.CarritoTypeConverter

@Database(entities = [Carrito::class,
    CarritoItem::class,
    Categoria::class,
    Comuna::class,
    Producto::class,
    Region::class,
    Usuario::class], version = 1)
@TypeConverters(CarritoTypeConverter::class)
abstract class VivaPetsDatabase : RoomDatabase() {
    abstract fun CarritoDao(): CarritoDao
    abstract fun CarritoItemDao(): CarritoItemDao
    abstract fun CategoriaDao(): CategoriaDao
    abstract fun ComunaDao(): ComunaDao
    abstract fun ProductoDao(): ProductoDao
    abstract fun RegionDao(): RegionDao
    abstract fun UsuarioDao(): UsuarioDao
    companion object {
        @Volatile
        private var INSTANCE: VivaPetsDatabase? = null

        fun getDatabase(context: Context): VivaPetsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VivaPetsDatabase::class.java,
                    "tienda_vp_db" // Name of your database file
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }



}