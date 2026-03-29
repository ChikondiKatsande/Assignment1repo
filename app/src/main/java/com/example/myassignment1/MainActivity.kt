package com.example.socialsparks

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var spinnerTime: Spinner
    lateinit var btnSuggest: Button
    lateinit var btnReset: Button
    lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link UI elements
        spinnerTime = findViewById(R.id.spinnerTime)
        btnSuggest = findViewById(R.id.btnSuggest)
        btnReset = findViewById(R.id.btnReset)
        txtResult = findViewById(R.id.txtResult)

        // Dropdown options
        val times = arrayOf(
            "Select Time",
            "Morning",
            "Mid-morning",
            "Afternoon",
            "Evening",
            "Dinner",
            "Night"
        )

        // Adapter for spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, times)
        spinnerTime.adapter = adapter

        // Suggest button
        btnSuggest.setOnClickListener {

            val selected = spinnerTime.selectedItem.toString()

            if (selected == "Select Time") {
                txtResult.text = "Please select a time first!"
                return@setOnClickListener
            }

            val suggestion = when (selected.lowercase()) {
                "morning" ->
                "mid-morning" ->
                "afternoon" ->
                "evening" ->
                "dinner" ->
                "night" ->
                else -> "Try again!"
            }

            txtResult.text = suggestion
        }

        // Reset button
        btnReset.setOnClickListener {
            spinnerTime.setSelection(0)
            txtResult.text = "Your suggestion will appear here 💡"
        }
    }
}