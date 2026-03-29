package com.example.socialsparks

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare the necessary UI components (these will link to XML elements)
    lateinit var spinnerTime: Spinner     // Dropdown for selecting time
    lateinit var btnSuggest: Button       // Button to generate suggestion
    lateinit var btnReset: Button         // Button to reset the app
    lateinit var txtResult: TextView      // TextView to display output

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        spinnerTime = findViewById(R.id.spinnerTime)
        btnSuggest = findViewById(R.id.btnSuggest)
        btnReset = findViewById(R.id.btnReset)
        txtResult = findViewById(R.id.txtResult)

        // Create a list of time options for the dropdown (Spinner)
        val times = arrayOf(
            "Select Time",     // Default option (acts like a placeholder)
            "Morning",
            "Mid-morning",
            "Afternoon",
            "Evening",
            "Dinner",
            "Night"
        )

        // Create an adapter to connect the array to the Spinner UI
        val adapter = ArrayAdapter(
            this,                                  // Current activity context
            android.R.layout.simple_spinner_dropdown_item, // Default layout style
            times                                  // Data source (array)
        )

        // Attach the adapter to the spinner
        spinnerTime.adapter = adapter

        // Set what happens when the "Get Suggestion" button is clicked
        btnSuggest.setOnClickListener {

            // Get the selected item from the spinner as a string
            val selected = spinnerTime.selectedItem.toString()

            // Check if user has not selected a valid option
            if (selected == "Select Time") {
                // Display error message
                txtResult.text = "Please select a time first!"
                return@setOnClickListener  // Stop further execution
            }

            // Use a when statement to determine suggestion
            val suggestion = when (selected.lowercase()) {

                // Each case matches a time and returns a suggestion
                "morning" -> "Go on a refreshing morning jog with a friend!"
                "mid-morning" -> "Catch up with a friend over a tasty breakfast and freshly brewed coffee"
                "afternoon" -> "Picnic day at the park with a friend!"
                "evening" -> "Get your friend group together for a fun game night"
                "dinner" -> "Host a dinner party, potluck style!"
                "night" -> "Go on a nice evening walk and stargaze with a partner or close friend"

                // Default case if the user inputs an invalid time of day
                else -> "Try again!"
            }

            // Display the suggestion in the TextView
            txtResult.text = suggestion
        }

        // Set what happens when the "Reset" button is clicked
        btnReset.setOnClickListener {

            // Reset spinner back to the first option ("Select Time")
            spinnerTime.setSelection(0)

            // Reset the result text to default message
            txtResult.text = "Your suggestion will appear here 💡"
        }
    }
}