package fr.epf.min1.projetandroidvelib.model

data class StationInformation(
    val station_id: Int,
    val name: String,
    val lat: Double,
    val lon: Double,
    val capacity: Int,
    val station_code: String,
    ){
        companion object {
            fun bdd(nb: Int = 40) =
                (1..nb).map{
                    StationInformation(6399, "Station du futur $it", 12.0, 12.0, 32, "AUEEO")
                }
        }
    }
