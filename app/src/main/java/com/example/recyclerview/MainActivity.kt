package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val data = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)


        for (i in 1..20) {
            data.add(Item("text$i", "text$i", R.drawable.ic_launcher_foreground))
        }

        val adapter = CustomAdapter(data) { position -> onItemClick(position) }
        recyclerView.adapter = adapter
    }

    private fun onItemClick(position: Int) {
        Toast.makeText(this, data[position].text, Toast.LENGTH_SHORT).show()
    }
}