package com.example.techlife
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OngHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ong_home_activity)

        val btProjects = findViewById<Button>(R.id.btProyectosOng)
        val btprofile = findViewById<Button>(R.id.btPerfilOng)
        btProjects.setOnClickListener {
            val intent = Intent(this, ONGProfileActivity::class.java)
            startActivity(intent)
        }

    }
}