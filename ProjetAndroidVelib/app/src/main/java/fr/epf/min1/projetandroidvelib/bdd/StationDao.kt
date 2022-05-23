package fr.epf.min1.projetandroidvelib.bdd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StationDao {

    @Query("SELECT * FROM stationEntity")
    suspend fun getAll(): List<StationEntity>

    @Insert
    suspend fun insert(vararg stations: StationEntity)
}