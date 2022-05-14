package fr.epf.min1.projetandroidvelib.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface StationsService {

    @GET("/opendata/Velib_Metropole/station_information.json")
    fun getStations() : Call<JsonObject>

    @GET("/opendata/Velib_Metropole/station_status.json")
    fun getStatus(): Call<JsonObject>
}