package com.dam2.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var enviar: Button = findViewById(R.id.Pulsar)
        val numTelefono = "123456789"
        val texto : TextView = findViewById(R.id.texto1)
        texto.text = numTelefono
        enviar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numTelefono")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }

        }
    }

}
