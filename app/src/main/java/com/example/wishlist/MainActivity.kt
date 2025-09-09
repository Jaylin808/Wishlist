package com.example.wishlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: WishlistAdapter
    val wishlistItems = mutableListOf<WishlistItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val itemNameInput: EditText = findViewById(R.id.itemNameInput)
        val itemPriceInput: EditText = findViewById(R.id.itemPriceInput)
        val itemUrlInput: EditText = findViewById(R.id.itemUrlInput)
        val submitButton: Button = findViewById(R.id.submitButton)

        recyclerView = findViewById(R.id.WishlistView)
        adapter = WishlistAdapter(wishlistItems)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        submitButton.setOnClickListener {
            val itemName = itemNameInput.text.toString()
            val itemPrice = itemPriceInput.text.toString()
            val itemUrl = itemUrlInput.text.toString()

            if (itemName.isNotBlank() && itemPrice.isNotBlank() && itemUrl.isNotBlank()) {
                val newItem = WishlistItem(itemName, itemPrice, itemUrl)
                wishlistItems.add(newItem)
                adapter.notifyItemInserted(wishlistItems.size - 1)
                recyclerView.scrollToPosition(wishlistItems.size - 1)
                Toast.makeText(this, "Item added!", Toast.LENGTH_SHORT).show()

                itemNameInput.text.clear()
                itemPriceInput.text.clear()
                itemUrlInput.text.clear()
            } else {
                Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_SHORT).show()
            }

        }
    }
}