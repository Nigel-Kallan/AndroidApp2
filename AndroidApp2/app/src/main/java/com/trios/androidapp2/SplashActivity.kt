package com.trios.androidapp2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the splash screen
        setContentView(R.layout.activity_splash)

        // Keep the splash screen visible for 2 seconds
        Handler(Looper.getMainLooper()).postDelayed({

            // Open the main Tim Hortons screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Close the splash screen
            finish()

        }, 2000)
    }
}