package com.example.acg_primosactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val COD_ACTIVITY_MAIN: Int = 69

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editText = findViewById<EditText>(R.id.editTexto)

        findViewById<Button>(R.id.buttonAction).setOnClickListener() {
            var numero: Int = Integer.parseInt(editText.text.toString())
            var intent = Intent(this, ListPrimos::class.java)
            intent.putExtra("numero", numero)
            startActivityForResult(intent, COD_ACTIVITY_MAIN)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var arrayNumeros = data?.getIntegerArrayListExtra("Array")
        Log.i("Primos", arrayNumeros.toString())
    }
}