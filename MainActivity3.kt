package com.example.practicumassignment

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practinum2.R

class DetailedViewScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnBack: Button?

        val days = arrayOf(
            "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"
        )
        val Min = arrayOf(
            12, 15, 18, 13, 17, 10, 10
        )
        val Max = arrayOf(
            25, 29, 22, 19, 20, 18, 16
        )
        val validWeatherConditions = arrayOf(
            "Sunny",
            "Sunny",
            "Windy",
            "Windy",
            "Sunny",
            "Raining",
            "Cold",
        )

        val txtDetails: TextView = findViewById(R.id.TxtDetails)
        val txtAverage: TextView = findViewById(R.id.TxtAverage)
        val btnBack: Button?
        btnBack = findViewById<Button>(R.id.btnBack)

        intent.getStringExtra("day")
        intent.getStringExtra("Min")
        intent.getStringExtra("Max")
        intent.getStringExtra("Weather Conditions")

        var details = ""
        for (i in days.indices) {
            details += "Day: ${days[i]}\n"
            details += "Min: ${Min[i]} Temperature\n"
            details += "Max: ${Max[i]} minutes\n"
            details += "Weather Conditions: ${ validWeatherConditions.getOrNull(i) ?: "N/A"}\n\n"
        }
        txtDetails.text = details

        val averageMin = Min.average()
        val averageMax = Max.average()
        txtAverage.text =
            "Average Morning Screen Time: ${"%.2f".format(averageMin)} Temperature\n" +
                    "Average Afternoon Screen Time: ${"%.2f".format(averageMax)} Temperature"

        btnBack.setOnClickListener {
            finish()
        }
    }
}