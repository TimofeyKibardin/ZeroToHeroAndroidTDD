package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.actionButton)
        textView = findViewById(R.id.titleTextView)
        progressBar = findViewById(R.id.progressBar)

        textView.visibility = View.GONE
        progressBar.visibility = View.GONE

        button.setOnClickListener {
            button.isEnabled = false
            textView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE

//            object : CountDownTimer(3500, 1000) {
//                override fun onTick(millisUntilFinished: Long) {
//                    // Do nothing
//                }
//
//                override fun onFinish() {
//                    progressBar.visibility = View.GONE
//                    textView.visibility = View.VISIBLE
//                    button.isEnabled = true
//                }
//            }.start()

            button.postDelayed({
                textView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
                button.isEnabled = true
            }, 3500)
        }
    }
}