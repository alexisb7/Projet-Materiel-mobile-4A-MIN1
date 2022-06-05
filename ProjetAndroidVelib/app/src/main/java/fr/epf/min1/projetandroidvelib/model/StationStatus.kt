package fr.epf.min1.projetandroidvelib.model

data class StationStatus (
    val stationId: Int,
    val isInstalled: Int,
    val isRenting: Int,
    val isReturning: Int,
    val numBikesAvailable: Int,
    val numDocksAvailable: Int,
    val eBike: Int,
    val mechanical: Int
)