package com.example.tubes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_input.*
import java.text.SimpleDateFormat
import java.util.*

class InputActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        database = FirebaseDatabase.getInstance()
        reference = database.getReference("Records")

        val saveButton = findViewById<Button>(R.id.save)
        val DateInput = findViewById<TextView>(R.id.dateinput)
        DateInput.text = getCurrentDate()

        saveButton.setOnClickListener{
            saveRecord()
            val intent = Intent(this, GetRecord::class.java)
            startActivity(intent)
        }
    }

    private fun saveRecord() {
        var date = dateinput.text.toString().trim()
        var mood = moodinput.text.toString().trim()
        var event = eventinput.text.toString().trim()
        var desc = descinput.text.toString().trim()

        if (mood.isNotEmpty()&&event.isNotEmpty()&&desc.isNotEmpty()){
            val record = Record(date,mood,event,desc)
            val id = reference.push().key
            reference.child(id!!).setValue(record)

            moodinput.setText("")
            eventinput.setText("")
            descinput.setText("")

        }else{
            Toast.makeText(this,"All field Required", Toast.LENGTH_LONG).show()
        }
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat(" EEEE, dd MMMM yyyy HH:mm a", Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
    }

}

