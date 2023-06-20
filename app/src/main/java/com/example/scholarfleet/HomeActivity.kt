package com.example.scholarfleet

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import com.example.scholarfleet.Database.Database
import com.example.scholarfleet.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        //Creación de la bd
        val admin = Database(this, "agenda", null, 1)
        //puntero
        val db = admin.writableDatabase

        //Evento click sobre el btn
        binding.textChange.setOnClickListener {
            //cambio de texto al textview
            binding.textHello.text = "Spiderman beyond the spiderverse"
            //Toast de notificación
            Toast.makeText(this, "Hola compañero este es un toast de notificación", Toast.LENGTH_SHORT).show()

        }
    }
}