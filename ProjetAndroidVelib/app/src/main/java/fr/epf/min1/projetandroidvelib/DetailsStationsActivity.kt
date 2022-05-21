package fr.epf.min1.projetandroidvelib

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonObject
import fr.epf.min1.projetandroidvelib.api.StatusService
import fr.epf.min1.projetandroidvelib.model.StationStatus
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsStationsActivity : AppCompatActivity() {

    lateinit var detailStation: StationStatus
    var stationId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_stations)
        stationId = intent.getIntExtra("station_id", -1)
        synchroApi()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.goto_map -> {
                startActivity(Intent(this, MapsActivity::class.java))
            }
            R.id.goto_favorites_stations -> {
                startActivity(Intent(this, FavoritesStationsActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun synchroApi() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://velib-metropole-opendata.smoove.pro/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(StatusService::class.java)
        val result = service.getStatus()
        result.enqueue(object: Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if(response.isSuccessful){
                    val result = response.body()
                    val data = result?.get("data")?.asJsonObject
                    val stations = data?.get("stations")?.asJsonArray
                    if (stations != null) {
                        for(i in stations){
                            val s = i.asJsonObject
                            val id = s?.get("station_id")?.asInt
                            if(stationId == id){
                                val typesBike = s?.get("num_bikes_available_types")?.asJsonArray
                                val typeM = typesBike?.get(0)?.asJsonObject
                                val mechanical = typeM?.get("mechanical")?.asInt
                                val typeE = typesBike?.get(1)?.asJsonObject
                                val eBike = typeE?.get("ebike")?.asInt
                                detailStation =
                                    StationStatus(
                                        id,
                                        s?.get("is_installed").asInt,
                                        s?.get("is_renting").asInt,
                                        s?.get("is_returning").asInt,
                                        s?.get("numBikesAvailable").asInt,
                                        s?.get("numDocksAvailable").asInt,
                                        mechanical!!,
                                        eBike!!
                                    )
                                printDetails()
                            }
                        }
                    }
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(applicationContext, "Erreur serveur", Toast.LENGTH_SHORT).show()
            }
        }
        )
    }

    private fun printDetails() {
        val name = intent.getStringExtra("station_name")
        val capacity = intent.getIntExtra("station_capacity", -1)
        val tvName = findViewById<TextView>(R.id.station_name)
        val tvCapacity = findViewById<TextView>(R.id.capacity)
        val capacityTV = findViewById<TextView>(R.id.capacity_tv)
        val tvNbBikeAvailable = findViewById<TextView>(R.id.nb_velo_dispo)
        val nbBikeAvailableTV = findViewById<TextView>(R.id.nb_velo_dispo_tv)
        val tvNbDockAvailable = findViewById<TextView>(R.id.nb_borne_dispo)
        val nbDockAvailableTV = findViewById<TextView>(R.id.nb_borne_dispo_tv)
        val tvNbMech = findViewById<TextView>(R.id.nb_mech)
        val nbMechTV = findViewById<TextView>(R.id.nb_mech_tv)
        val tvNbEbike = findViewById<TextView>(R.id.nb_ebike)
        val nbEbikeTV = findViewById<TextView>(R.id.nb_ebike_tv)
        tvName.text = name
        capacityTV.text = "Capacité : "
        nbBikeAvailableTV.text = "Nombre de vélos disponibles : "
        nbDockAvailableTV.text = "Nombre de bornes diponibles : "
        nbMechTV.text = "Nombre de vélos mécaniques : "
        nbEbikeTV.text = "Nombre de vélos électriques : "
        tvCapacity.text = ""+capacity
        tvNbBikeAvailable.text = ""+detailStation.numBikesAvailable
        tvNbDockAvailable.text = ""+detailStation.numDocksAvailable
        tvNbMech.text = ""+detailStation.mechanical
        tvNbEbike.text = ""+detailStation.eBike
    }
}