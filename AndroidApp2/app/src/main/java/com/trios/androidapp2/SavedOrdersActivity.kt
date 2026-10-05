package com.trios.androidapp2

import android.app.AlertDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SavedOrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the Saved Orders screen
        setContentView(R.layout.activity_saved_orders)

        // Connect the ListView
        val ordersListView =
            findViewById<ListView>(R.id.ordersListView)

        // Open SharedPreferences
        val sharedPreferences =
            getSharedPreferences("SavedOrders", MODE_PRIVATE)

        // Get the saved orders
        val savedOrders =
            sharedPreferences.getStringSet(
                "orders",
                emptySet()
            )?.toMutableList() ?: mutableListOf()

        // Display the saved orders
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            savedOrders
        )

        ordersListView.adapter = adapter

        // Tap an order to cancel/delete it
        ordersListView.setOnItemClickListener { _, _, position, _ ->

            val selectedOrder = savedOrders[position]

            // Ask before deleting
            AlertDialog.Builder(this)
                .setTitle("Cancel Order")
                .setMessage("Do you want to cancel this order?\n\n$selectedOrder")
                .setPositiveButton("Yes") { _, _ ->

                    // Remove order from the list
                    savedOrders.removeAt(position)

                    // Save the updated orders
                    sharedPreferences.edit()
                        .putStringSet("orders", savedOrders.toSet())
                        .apply()

                    // Refresh the ListView
                    adapter.notifyDataSetChanged()

                    Toast.makeText(
                        this,
                        "Order cancelled",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .setNegativeButton("No", null)
                .show()
        }
    }
}