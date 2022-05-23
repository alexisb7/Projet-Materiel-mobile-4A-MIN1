package fr.epf.min1.projetandroidvelib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.JsonObject
import fr.epf.min1.projetandroidvelib.api.InformationService
import fr.epf.min1.projetandroidvelib.databinding.ActivityMapsBinding
import fr.epf.min1.projetandroidvelib.model.StationInformation
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MapsActivity : AppCompatActivity(), GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback {

    var listStations: MutableList<StationInformation> = mutableListOf()
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        synchroApi()
        mMap.setOnInfoWindowClickListener(this)
    }

    override fun onInfoWindowClick(marker: Marker) {
        val intent = Intent(this, DetailsStationsActivity::class.java)
        for(i in listStations) {
            val stationPosition = LatLng(i.lat, i.lon)
            if (marker.position == stationPosition) {
                intent.putExtra("station_id", i.station_id)
                intent.putExtra("station_name", i.name)
                intent.putExtra("station_capacity", i.capacity)
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.goto_favorites_stations, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.favorites_stations_action -> {
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

        val service = retrofit.create(InformationService::class.java)
        val result = service.getStations()
        result.enqueue(object: Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if(response.isSuccessful){
                    val result = response.body()
                    val data = result?.get("data")?.asJsonObject
                    val stations = data?.get("stations")?.asJsonArray
                    if (stations != null) {
                        for(i in stations){
                            val s = StationInformation(
                                i.asJsonObject.get("station_id").asInt,
                                i.asJsonObject.get("name").asString,
                                i.asJsonObject.get("lat").asDouble,
                                i.asJsonObject.get("lon").asDouble,
                                i.asJsonObject.get("capacity").asInt,
                                i.asJsonObject.get("stationCode").asString)
                            listStations.add(s)
                            val position = LatLng(s.lat, s.lon)
                            mMap.addMarker(MarkerOptions()
                                .position(position)
                                .title(s.name)
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                                .snippet("Cliquer pour plus de détails")
                            )
                            val zoomLevel = 16.0f
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, zoomLevel))
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
}