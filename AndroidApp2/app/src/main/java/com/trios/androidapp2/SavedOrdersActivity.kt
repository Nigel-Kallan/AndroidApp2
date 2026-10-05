package com.trios.androidapp2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class SavedOrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the Saved Orders screen
        setContentView(R.layout.activity_saved_orders)

        // Connect the ListView
        val ordersListView =
            findViewById<ListView>(R.id.ordersListView)

        // Open the same SharedPreferences used in OrderActivity
        val sharedPreferences =
            getSharedPreferences("SavedOrders", MODE_PRIVATE)

        // Get the real saved orders
        val savedOrders =
            sharedPreferences.getStringSet(
                "orders",
                emptySet()
            )?.toList() ?: emptyList()

        // Display the saved orders in the ListView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            savedOrders
        )

        ordersListView.adapter = adapter
    }
}