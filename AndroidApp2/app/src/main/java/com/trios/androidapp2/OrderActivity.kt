package com.trios.androidapp2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the order screen
        setContentView(R.layout.activity_order)

        // Connect Kotlin variables to the views
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val drinkSpinner = findViewById<Spinner>(R.id.drinkSpinner)
        val sizeSpinner = findViewById<Spinner>(R.id.sizeSpinner)
        val saveOrderButton = findViewById<Button>(R.id.saveOrderButton)
        val recentOrdersTextView =
            findViewById<TextView>(R.id.recentOrdersTextView)

        // Open SharedPreferences
        val sharedPreferences =
            getSharedPreferences("SavedOrders", MODE_PRIVATE)

        // Drink choices
        val drinks = arrayOf(
            "Coffee",
            "Tea",
            "Hot Chocolate",
            "French Vanilla"
        )

        // Size choices
        val sizes = arrayOf(
            "Small",
            "Medium",
            "Large",
            "Extra Large"
        )

        // Drink Spinner
        val drinkAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            drinks
        )

        drinkAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        drinkSpinner.adapter = drinkAdapter

        // Size Spinner
        val sizeAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            sizes
        )

        sizeAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        sizeSpinner.adapter = sizeAdapter

        // Watch the customer's name as it is typed
        nameInput.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(
                text: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                text: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                val customerName =
                    text.toString().trim()

                // Get all saved orders
                val savedOrders =
                    sharedPreferences.getStringSet(
                        "orders",
                        emptySet()
                    ) ?: emptySet()

                // Find orders belonging to this customer
                val customerOrders =
                    savedOrders.filter {
                        it.startsWith(
                            "$customerName -",
                            ignoreCase = true
                        )
                    }

                // Display the customer's recent orders
                if (customerName.isEmpty() ||
                    customerOrders.isEmpty()
                ) {
                    recentOrdersTextView.text =
                        "Recent Orders: None"
                } else {
                    recentOrdersTextView.text =
                        "Recent Orders:\n" +
                                customerOrders.joinToString("\n")
                }
            }

            override fun afterTextChanged(
                text: Editable?
            ) {
            }
        })

        // Save Order button
        saveOrderButton.setOnClickListener {

            val customerName =
                nameInput.text.toString().trim()

            val selectedDrink =
                drinkSpinner.selectedItem.toString()

            val selectedSize =
                sizeSpinner.selectedItem.toString()

            if (customerName.isEmpty()) {

                nameInput.error = "Please enter your name"

            } else {

                // Create the order
                val order =
                    "$customerName - $selectedDrink - $selectedSize"

                // Get existing saved orders
                val savedOrders =
                    sharedPreferences.getStringSet(
                        "orders",
                        mutableSetOf()
                    )?.toMutableSet() ?: mutableSetOf()

                // Add the new order
                savedOrders.add(order)

                // Save the updated list
                sharedPreferences.edit()
                    .putStringSet("orders", savedOrders)
                    .apply()

                // Confirmation message
                Toast.makeText(
                    this,
                    "Order saved for $customerName",
                    Toast.LENGTH_LONG
                ).show()

                // Clear the customer's name
                nameInput.text.clear()
            }
        }
    }
}