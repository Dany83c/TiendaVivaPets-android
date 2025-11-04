package com.example.tiendavivapets.data.typeConverter

import androidx.compose.ui.input.key.type
import androidx.room.TypeConverter
import com.example.tiendavivapets.data.modelo.CarritoItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class CarritoTypeConverter {
    // lo que hace este codigo es tomar la lista de los productos del carrito
    // y lo transforma en un JSON
    //y viceversa
    private val gson = Gson()

    @TypeConverter
    fun fromProductList(productos: List<CarritoItem>?): String? {
        if (productos == null) {
            return null
        }
        val type = object : TypeToken<List<CarritoItem>>() {}.type
        return gson.toJson(productos, type)
    }

    @TypeConverter
    fun toProductList(productosString: String?): List<CarritoItem>? {
        if (productosString.isNullOrEmpty()) {
            return null
        }
        val type = object : TypeToken<List<CarritoItem>>() {}.type
        return gson.fromJson(productosString, type)
    }
}
