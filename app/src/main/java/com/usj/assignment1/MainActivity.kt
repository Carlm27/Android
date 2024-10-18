package com.usj.assignment1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var showListButton: Button
    private var itemList = mutableListOf("Harry Potter and the Sorcerer's Stone", "A Game of Thrones", "The Lord of the Rings", "The Hunger Games", "The Da Vinci Code")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        showListButton = findViewById(R.id.showListButton)

        recyclerView.layoutManager = LinearLayoutManager(this)
        itemAdapter = ItemAdapter(itemList) { item ->
            onItemClick(item)
        }
        recyclerView.adapter = itemAdapter

        recyclerView.visibility = View.GONE

        showListButton.setOnClickListener {
            recyclerView.visibility = View.VISIBLE
            showListButton.visibility = View.GONE
        }
    }

    private fun onItemClick(item: String) {
        Toast.makeText(this, "Clicked: $item", Toast.LENGTH_SHORT).show()
    }
}
