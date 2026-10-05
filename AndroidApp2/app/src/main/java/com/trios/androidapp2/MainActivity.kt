package com.trios.androidapp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the main Tim Hortons menu
        setContentView(R.layout.activity_main)

        // Get the New Order button
        val newOrderButton =
            findViewById<Button>(R.id.newOrderButton)

        // Open OrderActivity when New Order is pressed
        newOrderButton.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        // Get the Saved Orders button
        val savedOrdersButton =
            findViewById<Button>(R.id.savedOrdersButton)

        // Open SavedOrdersActivity when Saved Orders is pressed
        savedOrdersButton.setOnClickListener {
            val intent = Intent(this, SavedOrdersActivity::class.java)
            startActivity(intent)
        }
    }
}