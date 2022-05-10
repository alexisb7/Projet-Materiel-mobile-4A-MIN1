package fr.epf.min1.projetandroidvelib

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)
        val addUserButton = findViewById<Button>(R.id.add_client_button)
        addUserButton.setOnClickListener{
            startActivity(Intent(this, MapsActivity::class.java))
        }
    }
}