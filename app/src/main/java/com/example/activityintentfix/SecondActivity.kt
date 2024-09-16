package com.example.activityintentfix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val btnLogin: Button = findViewById(R.id.btn_toast)

        val registeredUsername = intent.getStringExtra("username")
        val registeredPassword = intent.getStringExtra("password")
        val registeredEmail = intent.getStringExtra("email")
        val registeredPhone = intent.getStringExtra("phone")

        btnLogin.setOnClickListener {
            val enteredUsername = usernameEditText.text.toString().trim()
            val enteredPassword = passwordEditText.text.toString().trim()

            if (enteredUsername == registeredUsername && enteredPassword == registeredPassword) {
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("username", enteredUsername)
                intent.putExtra("email", registeredEmail)
                intent.putExtra("phone", registeredPhone)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
