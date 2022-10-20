package com.example.techlife
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class LogingVoluntarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loging_voluntario_activity)

        val btenterVoluntario = findViewById<Button>(R.id.btlogearvoluntario)

        btenterVoluntario.setOnClickListener {
            val intent = Intent(this, VoluntarioHomeActivity::class.java)
            startActivity(intent)
        }
    }
}