package com.example.tiendavivapets.data.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tiendavivapets.data.modelo.Usuario

@Dao
interface UsuarioDao {
    @Insert
    suspend fun insertar(usuario: Usuario)

    @Query("SELECT * FROM usuarios")
    suspend fun getAll(): List<Usuario>

    @Query("SELECT * FROM usuarios where id = :usuarioid")
    suspend fun getFromId(usuarioid: Int): List<Usuario>

    @Query("SELECT * FROM usuarios where email = :usuarioemail")
    suspend fun getFromEmail(usuarioemail: String): List<Usuario>

    @Query("SELECT * FROM usuarios where nombre = :nombreid")
    suspend fun getFromNombre(nombreid: String): List<Usuario>


}

