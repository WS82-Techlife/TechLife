package com.example.techlife
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)

        val btOng= findViewById<Button>(R.id.btOng)
        val btVoluntario = findViewById<Button>(R.id.btVoluntario)

        btOng.setOnClickListener {
            val intent = Intent(this, LogingOngActivity::class.java)
            startActivity(intent)
        }

        btVoluntario.setOnClickListener {
            val intent = Intent(this, LogingVoluntarioActivity::class.java)
            startActivity(intent)
        }
    }
}