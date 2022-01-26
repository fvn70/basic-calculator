package org.hyperskill.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val editText by lazy { findViewById<EditText>(R.id.editText) }
    var op1 = 0.0
    var op2 = 0.0
    var simbol = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     }

    fun addChar(v: View) {
        val btn: Button = findViewById(v.id)
        val btnStr = btn.text.toString()
        val editStr = editText.text.toString()
        when (btnStr) {
            "CLEAR" -> editText.setText("0")
            "0" -> {
                if (editStr !in "-0" ) editText.text.append(btn.text)
            }
            "." -> {
                if (!editText.text.contains(".")) {
                    if (editStr == "-") {
                        editText.setText("-0.")
                    } else {
                        editText.text.append(btn.text)
                    }
                } else editText.text
            }
            in "+-*/" -> {
                if (btnStr == "-" && editStr == "0") {
                    editText.setText("-")
                } else {
                    op1 = editStr.toDouble()
                    editText.setText("0")
                    simbol = btnStr
                }
            }
            "=" -> {
                op2 = editStr.toDouble()
                val res: Double = when(simbol) {
                    "+" -> op1 + op2
                    "-" -> op1 - op2
                    "*" -> op1 * op2
                    "/" -> op1 / op2
                    else -> 0.0
                }
                editText.setText(res.toString())
                op1 = editStr.toDouble()
            }
            else -> {
                if (!editText.text.contains("0.") && editText.text.first().toChar() == '0') {
                    editText.text.clear()
                }
                editText.text.append(btn.text) }
        }
    }
}
