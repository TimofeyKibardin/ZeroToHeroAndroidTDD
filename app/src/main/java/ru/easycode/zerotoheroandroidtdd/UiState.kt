package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(textView: TextView, buttonMin: Button, buttonMax: Button)

    data class Min(private val text: String) : UiState {
        override fun apply(textView: TextView, buttonMin: Button, buttonMax: Button) {
            textView.text = text
            buttonMin.isEnabled = false
            buttonMax.isEnabled = true
        }
    }

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView, buttonMin: Button, buttonMax: Button) {
            textView.text = text
            buttonMin.isEnabled = true
            buttonMax.isEnabled = true
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(textView: TextView, buttonMin: Button, buttonMax: Button) {
            textView.text = text
            buttonMin.isEnabled = true
            buttonMax.isEnabled = false
        }
    }
}
