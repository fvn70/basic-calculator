package org.hyperskill.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val editText by lazy { findViewById<EditText>(R.id.editText) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     }

    fun addChar(v: View) {
        val btn: Button = findViewById(v.id)
        editText.text = when (btn.text) {
            "CLEAR" -> {
                editText.text.clear()
                editText.text.append("0") }
            "0" -> {
                if (editText.text.toString() != "0") {
                    editText.text.append(btn.text)
                } else editText.text }
            "." -> {
                if (!editText.text.contains(".")) {
                    editText.text.append(btn.text)
                } else editText.text }
            else -> {
                if (!editText.text.contains("0.") && editText.text.first().toChar() == '0') {
                    editText.text.clear()
                }
                editText.text.append(btn.text) }
        }
    }
}
