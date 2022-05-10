package fr.epf.min1.projetandroidvelib

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ConnectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)
        val newUserButton = findViewById<Button>(R.id.new_user_button)
        val connectionButton = findViewById<Button>(R.id.connection_button)
        newUserButton.setOnClickListener {
            startActivity(Intent(this, AddUserActivity::class.java))
        }
        connectionButton.setOnClickListener{
            startActivity(Intent(this, MapsActivity::class.java))
        }
    }
}