package fr.epf.min1.projetandroidvelib.bdd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StationEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun stationDao() : StationDao
}