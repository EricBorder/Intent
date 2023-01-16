package com.dam2.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Recoge el Intent que ha iniciado la actividad
        val intent = intent
        // Get the Intent that started this activity and extract the string
        val message = intent.getIntExtra("REQUEST_EXTRA_MESSAGE", 7)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textoSalir)
        textView.text = message.toString()


        val botonsalir = findViewById<Button>(R.id.suma)
        botonsalir.setOnClickListener {
            //val intento2 = Intent(this, SecondActivity::class.java)
            val numero1 = intent.getIntExtra("EXTRA_MESSAGE", 7)
            val numero2 = intent.getIntExtra("NUMERO2", 7)
            intent.putExtra("Resultado", numero1 + numero2)
            //intent.putExtra("saludo", "Hola")
            //intent.putExtra("despedida", "Adios")
            //intent.putExtra("despedida2", "Chao")
            Log.d("mensaje", "actualizado")
            /* startActivity(intento2)*/
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        val botonsalir1 = findViewById<Button>(R.id.resta)
        botonsalir1.setOnClickListener {
            //val intento2 = Intent(this, SecondActivity::class.java)
            // Meto un nuevo dato en el intent
            val numero1 = intent.getIntExtra("EXTRA_MESSAGE", 7)
            val numero2 = intent.getIntExtra("NUMERO2", 7)
            intent.putExtra("Resultado2", numero1 - numero2)
            Log.d("mensaje", "actualizado")
            /* startActivity(intento2)*/
            // Configuro el result para que la Main lo tenga disponible
            // Posibles resultados:
            //    Activity.RESULT_OK
            //    Activity.RESULT_CANCELED
            setResult(Activity.RESULT_OK, intent)
            // cierro la activity
            finish()
        }
        val botonsalir2 = findViewById<Button>(R.id.multiplicar)
        botonsalir2.setOnClickListener {
            //val intento2 = Intent(this, SecondActivity::class.java)
            val numero1 = intent.getIntExtra("EXTRA_MESSAGE", 7)
            val numero2 = intent.getIntExtra("NUMERO2", 7)
            intent.putExtra("Resultado3", numero1 * numero2)
            Log.d("mensaje", "actualizado")
            /* startActivity(intento2)*/
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}