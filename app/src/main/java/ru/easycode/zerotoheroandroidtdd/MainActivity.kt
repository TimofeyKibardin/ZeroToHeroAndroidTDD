package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var layout: LinearLayout
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.rootLayout)
        button = findViewById(R.id.removeButton)
        textView = findViewById(R.id.titleTextView)

        button.setOnClickListener {
            layout.removeView(textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //childCount - количество вложенных в LinearLayout объектов
        val removedTextView = layout.childCount == 1
        outState.putBoolean(KEY, removedTextView)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removedTextView = savedInstanceState.getBoolean(KEY)
        if (removedTextView)
            layout.removeView(textView)
    }

    companion object {
        private const val KEY = "key"
    }
}