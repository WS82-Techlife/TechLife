package com.example.techlife
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class LogingOngActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loging_ong_activity)

        val btenterOng = findViewById<Button>(R.id.btlogearOng)

        btenterOng.setOnClickListener {
            val intent = Intent(this, OngHomeActivity::class.java)
            startActivity(intent)
        }
    }
}