package fr.epf.min1.projetandroidvelib

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import fr.epf.min1.projetandroidvelib.bdd.AppDataBase
import fr.epf.min1.projetandroidvelib.model.StationInformation
import kotlinx.coroutines.runBlocking

class FavoritesStationsActivity : AppCompatActivity() {

    private var stationAdapter: StationAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites_stations)

        val recyclerView = findViewById<RecyclerView>(R.id.list_favorites_stations)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //val listStationsFavorites = StationInformation.bdd(40)
        val bdd = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "stationEntity"
        ).build()

        val stationDao = bdd.stationDao()
        runBlocking {
            val listStationsFavorites = stationDao.getAll()
            stationAdapter = StationAdapter(listStationsFavorites)
            recyclerView.adapter = StationAdapter(listStationsFavorites)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.goto_map, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.goto_map_action -> {
                startActivity(Intent(this, MapsActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}