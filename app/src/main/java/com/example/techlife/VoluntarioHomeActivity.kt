package com.example.techlife
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class VoluntarioHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.voluntario_home_activity)
        val btprofilevoluntario = findViewById<Button>(R.id.btPerfilVoluntario)

        btprofilevoluntario.setOnClickListener {
            val intent = Intent(this, VoluntarioProfileActivity::class.java)
            startActivity(intent)
        }
    }
}