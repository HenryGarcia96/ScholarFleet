package com.example.scholarfleet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.WindowManager.*
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.Toast

@Suppress("DEPRECATION")
class SplashLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_layout)

        Toast.makeText(this, "Esto es un milagro, ya le entendi", Toast.LENGTH_LONG).show()

        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN
        )

        Handler().postDelayed({


            val envio = Intent(this@SplashLayout, HomeActivity::class.java)
            startActivity(envio)
            finish()
        }, 5000)
    }
}