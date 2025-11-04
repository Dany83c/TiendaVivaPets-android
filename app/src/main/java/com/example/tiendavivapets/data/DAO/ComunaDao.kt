package com.example.tiendavivapets.data.DAO
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tiendavivapets.data.modelo.Comuna

@Dao
interface  ComunaDao {
    @Insert
    suspend fun insertar(comuna: Comuna)

    @Query("SELECT * FROM comunas where regionid = :regionid")
    suspend fun getAllFromRegion(regionid: Int): List<Comuna>

}