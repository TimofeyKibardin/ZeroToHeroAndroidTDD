package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var textView = findViewById<TextView>(R.id.titleTextView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.changeButton)
        textView = findViewById(R.id.titleTextView)

        button.setOnClickListener {
            textView.setText("I am an Android Developer!")
        }
    }

    //Сохраняем при пересоздании активити
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("key", textView.text.toString())
    }

    //Восстанавливаем значения
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState.getString("key")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}