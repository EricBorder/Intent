package com.dam2.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var enviar: Button = findViewById(R.id.Pulsar)
        enviar.setOnClickListener {
            val intento1 = Intent(this, SecondActivity::class.java)
            // Añade datos adicionales al Intent
            intento1.putExtra("EXTRA_MESSAGE", 8)
            intento1.putExtra("NUMERO2",4)
            // Inicia la segunda actividad
            startActivityForResult(intento1, REQUEST_EXTRA_MESSAGE)
            /*startActivityForResult(intento1, REQUEST_PERMISSION)
            startActivityForResult(intento1, REQUEST_TO_POST)*/
        }
    }

    // recoje el intent cuando hacemos setResult() en la SecondActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Definimos el text view para mostrar el dato que nos manda la Second
        val textView1 = findViewById<TextView>(R.id.texto1)
        val textView2 = findViewById<TextView>(R.id.texto2)
        val textView3 = findViewById<TextView>(R.id.texto3)
        // Comprueba que el resultado es OK
        if (resultCode != Activity.RESULT_OK) return
        Log.d("asd", requestCode.toString())
        // Puedo distinguir diferentes acciones según el requestCode
        when (requestCode) {
            REQUEST_EXTRA_MESSAGE -> {
                // si el intent no es null muestro el resultado
                if (data != null) {
                    Log.d("asd", "recibido")
                    //textView1.text = data.getStringExtra("saludo")
                    textView1.text = data.getIntExtra("Resultado",0).toString()
                    textView2.text = data.getIntExtra("Resultado2",0).toString()
                    textView3.text = data.getIntExtra("Resultado3",0).toString()
                }; }
            REQUEST_PERMISSION -> {
                if (data != null) {
                    Log.d("asd", "recibido")
                    textView2.text = data.getIntExtra("Resultado2",0).toString()
                }; }

            REQUEST_TO_POST -> {
                if (data != null) {
                    Log.d("asd", "recibido")
                    textView3.text = data.getIntExtra("Resultado3",0).toString()
                }; }

        }
    }

    companion object {
        const val REQUEST_EXTRA_MESSAGE = 1
        const val REQUEST_PERMISSION = 2
        const val REQUEST_TO_POST = 3
    }
}
