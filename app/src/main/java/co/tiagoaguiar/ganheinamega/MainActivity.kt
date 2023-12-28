package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val editNumber: EditText = findViewById(R.id.edit_number)
        val textResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        btnGenerate.setOnClickListener {
            val text = editNumber.text.toString()
            numberGenerator(text, textResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        if (text.isEmpty()) {
            Toast.makeText(this, "Informe um número entre 6 e 15!", Toast.LENGTH_LONG).show()
            return
        }

        val qtd = text.toInt()
        val inValidRange = qtd in 6..15
        if (inValidRange.not()) {
            Toast.makeText(this, "Informe um número entre 6 e 15!", Toast.LENGTH_LONG).show()
            return
        }

        val numbers = mutableSetOf<Int>()
        val random = Random()
        while (numbers.size < qtd) {
            val number = random.nextInt(60) + 1
            numbers.add(number)
        }

        txtResult.text = numbers.joinToString(" - ")
    }
}