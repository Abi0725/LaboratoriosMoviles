package com.miranda.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var actionCalculate: Button
    private lateinit var bmiTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding()
        setListeners()
    }

    private fun binding() {
        weightEditText = findViewById(R.id.weight_card)
        heightEditText = findViewById(R.id.height_text_view)


        fun validateInput(weight: String, height: String): Any {
            TODO("Not yet implemented")
        }

        private fun setListeners() {
        actionCalculate.setOnClickListener {
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()

            if (!validateInput(weight, height)) {
                clearResult()
                return@setOnClickListener
            }

            weightEditText.clearFocus()
            heightEditText.clearFocus()


            val bmi = calculateBmi(weight.toFloat(), height.toFloat())
            // round to 2 decimals
            val bmiTwoDigits = String.format("%.2f", bmi).toFloat()
            displayResult(bmiTwoDigits)
        }
    }

    /*
    @param  weight  decimal value that represents the weight of a person in kilograms
    @param  height  decimal value that represents the height of a person in centimeters
    @return         decimal value that represents the BMI of a person
    */
    private fun calculateBmi(weight: Float, height: Float): Float = weight / ( (height / 100) * (height / 100))


    private fun validateInput(weight: String?, height: String?): Boolean {
        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty!", Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty!", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> true
        }
    }

    private fun displayResult(bmi: Float) {
        bmiTextView.text = bmi.toString()
        infoTextView.text = getString(R.string.normal_weight_info)

        var informationResult = ""
        var color = 0

        when {
            bmi < 18.50 -> {
                informationResult = getString(R.string.under_weight_label)
                color = R.color.under_weight
            }
            bmi in 18.50..24.99 -> {
                informationResult = getString(R.string.healthy_label)
                color = R.color.normal_weight
            }
            bmi in 25.00..29.99 -> {
                informationResult = getString(R.string.over_weight_label)
                color = R.color.over_weight
            }
            bmi > 29.99 -> {
                informationResult = getString(R.string.obese_label)
                color = R.color.obese
            }
        }

        resultTextView.setTextColor(ContextCompat.getColor(this, color))
        resultTextView.text = informationResult
    }

    private fun clearResult() {
        bmiTextView.text = ""
        resultTextView.text = ""
        infoTextView.text = ""
    }
}