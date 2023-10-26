package com.example.acg_primosactivity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class ListPrimos : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.primos_list)

        var resultIntent = Intent(this, MainActivity::class.java)
        resultIntent.putIntegerArrayListExtra("Array", crearListaPrimos(intent.getIntExtra("numero", -1)))
        setResult(RESULT_OK, resultIntent)

        finish()
    }

    private fun crearListaPrimos(num: Int): ArrayList<Int> {
        var listArray = ArrayList<Int>()

        for (i in 2 .. num) {
            if (esPrimo(i, i-1)) {
                listArray.add(i)
            }
        }
        return listArray;
    }

    private fun esPrimo(num: Int, divisor: Int): Boolean {
        if (divisor == 1) {
            return true
        } else if ((num % divisor) == 0) {
            return false
        } else {
            return esPrimo(num, (divisor - 1))
        }
    }

}