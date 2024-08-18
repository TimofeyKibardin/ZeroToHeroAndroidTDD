package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*Вариант с xml. В принципе, если не прям много вьюх - то можно через xml
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.changeButton)
        val textView = findViewById<TextView>(R.id.titleTextView)

        button.setOnClickListener {
            textView.setText("I am an Android Developer!")
        }
        */

        //Вариант через Java-объекты
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.id = R.id.rootLayout

        val textView = TextView(this)
        textView.id = R.id.titleTextView
        textView.setText("Hello World!")
        linearLayout.addView(textView)

        val button = Button(this)
        button.id = R.id.changeButton
        button.setText("change")
        linearLayout.addView(button)

        setContentView(linearLayout)

        button.setOnClickListener {
            textView.setText("I am an Android Developer!")
        }
    }
}