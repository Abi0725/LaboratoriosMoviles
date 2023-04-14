package com.miranda.intents


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nameTexView = findViewById<TextView>(R.id.name)
        val nameTextValue = intent.getStringExtra("name")
        nameTexView.text = nameTextValue

        val emailTexView = findViewById<TextView>(R.id.email)
        val emailTextValue = intent.getStringExtra("email")
        emailTexView.text = emailTextValue

        val phoneTexView = findViewById<TextView>(R.id.phone)
        val phoneTextValue = intent.getStringExtra("phone")
        phoneTexView.text = phoneTextValue

        val buttonSend = findViewById<Button>(R.id.buttonShare)

        buttonSend.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Name: $nameTexView\nEmail: $emailTexView\nPhone: $phoneTexView")

            startActivity(Intent.createChooser(shareIntent, "Share to:"))
        }

    }
}