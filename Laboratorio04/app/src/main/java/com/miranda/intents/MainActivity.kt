package com.miranda.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.SaveButton)
        val nameEditText = findViewById<EditText>(R.id.InputNameField)
        val emailEditText = findViewById<EditText>(R.id.InputEmailField)
        val phoneEditText= findViewById<EditText>(R.id.InputPhoneField)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("email", emailEditText.text.toString())
            intent.putExtra("phone", phoneEditText.text.toString())
            startActivity(intent)
        }

    }
}