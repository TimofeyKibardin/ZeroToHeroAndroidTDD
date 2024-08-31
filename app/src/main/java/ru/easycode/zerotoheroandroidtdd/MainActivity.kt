package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private var state: State = State.Initial
    private lateinit var layout: LinearLayout
    private lateinit var textView: TextView
    private lateinit var button: Button

    companion object {
        private const val KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)

        button.setOnClickListener {
            state = State.Removed
            state.apply(layout, textView, button)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, State::class.java) as State
        } else {
            savedInstanceState.getSerializable(KEY) as State
        }

        state.apply(layout, textView, button)
    }
}

interface State : Serializable {

    fun apply(layout: LinearLayout, textView: TextView, button: Button)

    object Initial : State {
        override fun apply(layout: LinearLayout, textView: TextView, button: Button) = Unit
    }

    object Removed : State {
        override fun apply(layout: LinearLayout, textView: TextView, button: Button) {
            layout.removeView(textView)
            button.isEnabled = false
        }
    }
}