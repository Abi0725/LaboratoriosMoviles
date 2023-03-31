package com.miranda.moneyamount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var moneyAmount : TextView
    private lateinit var fiveCentsCoin : ImageButton
    private lateinit var tenCentsCoin : ImageButton
    private lateinit var quarterCoin : ImageButton
    private lateinit var dollarCoin : ImageButton
    private var totalAmount = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        setClickListeners()
        moneyAmount.text = "$${totalAmount}"
    }

    private fun bind() {
        moneyAmount = findViewById(R.id.tittle_text_view)
        fiveCentsCoin = findViewById(R.id.five_cents_text_view)
        tenCentsCoin = findViewById(R.id.ten_cents_text_view)
        quarterCoin = findViewById(R.id.quarter_text_view)
        dollarCoin = findViewById(R.id.one_dollar_text_view)
    }

    private fun setClickListeners() {
        fiveCentsCoin.setOnClickListener {
            totalAmount += 0.05
            totalAmount = String.format("%.2f", totalAmount).toDouble()
            moneyAmount.text = "$${totalAmount}"
        }
        tenCentsCoin.setOnClickListener {
            totalAmount += 0.10
            totalAmount = String.format("%.2f", totalAmount).toDouble()
            moneyAmount.text = "$${totalAmount}"
        }
        quarterCoin.setOnClickListener {
            totalAmount += 0.25
            totalAmount = String.format("%.2f", totalAmount).toDouble()
            moneyAmount.text = "$${totalAmount}"
        }
        dollarCoin.setOnClickListener {
            totalAmount += 1.00
            totalAmount = String.format("%.2f", totalAmount).toDouble()
            moneyAmount.text = "$${totalAmount}"
        }
    }
}

