package com.example.tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trackButton = findViewById<Button>(R.id.track)
        trackButton.setOnClickListener{
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }
        val recordsButton = findViewById<Button>(R.id.records)
        recordsButton.setOnClickListener{
            val intent = Intent(this, GetRecord::class.java)
            startActivity(intent)
        }

    }
}