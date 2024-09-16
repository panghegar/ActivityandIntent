package com.example.activityintentfix

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // Fetch the TextViews where the username, email, and phone will be displayed
        val welcomeTextView: TextView = findViewById(R.id.welcome)
        val emailTextView: TextView = findViewById(R.id.email)
        val phoneTextView: TextView = findViewById(R.id.phone)

        // Get the username, email, and phone from the intent
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")

        // Set color for the user input (username, email, phone) using SpannableString
        val colorBlue = Color.parseColor("#525bff")

        // Set Username text with color
        val welcomeText = "Welcome $username"
        val welcomeSpannable = SpannableString(welcomeText)
        welcomeSpannable.setSpan(
            ForegroundColorSpan(colorBlue),
            welcomeText.indexOf(username ?: ""),
            welcomeText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        welcomeTextView.text = welcomeSpannable

        // Set Email text with color
        val emailText = "Your email $email has been activated"
        val emailSpannable = SpannableString(emailText)
        emailSpannable.setSpan(
            ForegroundColorSpan(colorBlue),
            emailText.indexOf(email ?: ""),
            emailText.indexOf(" has been"),
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        emailTextView.text = emailSpannable

        // Set Phone text with color
        val phoneText = "Your phone $phone has been registered"
        val phoneSpannable = SpannableString(phoneText)
        phoneSpannable.setSpan(
            ForegroundColorSpan(colorBlue),
            phoneText.indexOf(phone ?: ""),
            phoneText.indexOf(" has been"),
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        phoneTextView.text = phoneSpannable
    }
}
