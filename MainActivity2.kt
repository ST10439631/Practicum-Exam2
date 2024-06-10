package com.example.practinum2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val txtDay: TextView = findViewById(R.id.TxtDay)
        val txtMin: TextView = findViewById(R.id.TxtMin)
        val txtMax: TextView = findViewById(R.id.TxtMax)
        val txtWeatherConditions: TextView = findViewById(R.id.TxtWeatherConditions)

        val btnDisplay: Button = findViewById(R.id.BtnDisplay)
        val btnClear: Button = findViewById(R.id.BtnClear)
        val btnBack: Button = findViewById(R.id.BtnBack)

        val validDays = arrayOf(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        )
        val validMinTemperature = arrayOf(
            "12", "15", "15","13","17","10", "10",

        )
        val validMaxTemperature = arrayOf(
            "25", "29", "22", "19",
            "20", "18", "16"
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

        btnDisplay.setOnClickListener {
            val day = txtDay.text.toString()
            val Min = txtMin.text.toString()
            val Max = txtMax.text.toString()
            val WeatherConditions = txtWeatherConditions.text.toString()

            if (validDays.contains(day) && validMinTemperature.contains(Min) &&
                validMaxTemperature.contains(Max) && validWeatherConditions.contains(WeatherConditions)
            ) {
                val intent = Intent(this, MainActivity2::class.java).apply {
                    putExtra("day", day)
                    putExtra("MinTemperature", Min)
                    putExtra("MaxTemperature", Max)
                    putExtra("WeatherConditions", WeatherConditions)
                }
                startActivity(intent)
            }
        }

        btnClear.setOnClickListener {
            txtDay.text.clear()
            txtMin.text.clear()
            txtMax.text. clear()
            txtWeatherConditions.text.clear()
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}

private fun Any.clear() {
    TODO("Not yet implemented")
}





