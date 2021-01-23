package com.example.tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_getrecord.*

class GetRecord() : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.record_layout)

        database = FirebaseDatabase.getInstance()
        reference = database.getReference("Records")
        recordActivity()

        val backButton = findViewById<Button>(R.id.back)
        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun recordActivity(){
        reference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Log.e("cancel", p0.toString())
            }

            override fun onDataChange(p0: DataSnapshot) {
                val list = ArrayList<Record>()
                for (data in p0.children){
                    val record=data.getValue(Record::class.java)
                    list.add(record as Record)
                }
                if (list.size>0){
                    val adapter = RecordAdapter(list)
                    recyclerView.adapter = adapter
                }

            }

        })
    }

}