package fr.epf.min1.projetandroidvelib.bdd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StationEntity (
        @PrimaryKey val id: Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "operationnel") val op: String,
        @ColumnInfo(name = "capacity") val capacity: Int,
        @ColumnInfo(name = "nb_bike_availabale") val nbBikeAvailable: Int,
        @ColumnInfo(name = "nb_dock_availabale") val nbDockAvailable: Int,
        @ColumnInfo(name = "mechanical") val mechanical: Int,
        @ColumnInfo(name = "eBike") val eBike: Int
        )