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
        val url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
        enviar.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }

        }
    }

}
