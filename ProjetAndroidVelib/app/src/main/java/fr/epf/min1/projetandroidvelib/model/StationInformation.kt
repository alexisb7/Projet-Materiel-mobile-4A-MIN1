package fr.epf.min1.projetandroidvelib.model

data class StationInformation(
    val station_id: Int,
    val name: String,
    val lat: Double,
    val lon: Double,
    val capacity: Int,
    val station_code: String
)
