package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private var count: Count = Count.Base(2, 4, 0)
    private lateinit var uiState: UiState

    private lateinit var textView: TextView
    private lateinit var buttonIncrement: Button
    private lateinit var buttonDecrement: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        buttonIncrement = findViewById(R.id.incrementButton)
        buttonDecrement = findViewById(R.id.decrementButton)

        buttonIncrement.setOnClickListener{
            uiState = count.increment(textView.text.toString())
            uiState.apply(textView, buttonDecrement, buttonIncrement)
        }

        buttonDecrement.setOnClickListener{
            uiState = count.decrement(textView.text.toString())
            uiState.apply(textView, buttonDecrement, buttonIncrement)
        }

        if (savedInstanceState == null) {
            uiState = count.initial(textView.text.toString())
            uiState.apply(textView, buttonDecrement, buttonIncrement)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable(KEY, UiState::class.java)!!
        uiState.apply(textView, buttonDecrement, buttonIncrement)
    }

    companion object {
        private const val KEY = "uiStateKey"
    }
}