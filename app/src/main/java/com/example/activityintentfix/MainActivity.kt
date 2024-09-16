package com.example.activityintentfix

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isPasswordVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val phoneEditText: EditText = findViewById(R.id.phoneEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val btnRegister: Button = findViewById(R.id.btn_register)

        btnRegister.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            intent.putExtra("phone", phone)
            intent.putExtra("password", password)
            startActivity(intent)
        }

        passwordEditText.setOnTouchListener { _, event ->
            val DRAWABLE_END = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (passwordEditText.right - passwordEditText.compoundDrawables[DRAWABLE_END].bounds.width())) {
                    togglePasswordVisibility(passwordEditText)
                    return@setOnTouchListener true
                }
            }
            false
        }
    }

    private fun togglePasswordVisibility(passwordEditText: EditText) {
        if (isPasswordVisible) {
            passwordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
            passwordEditText.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_lock, 0, R.drawable.ic_visibility, 0
            )
        } else {
            passwordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
            passwordEditText.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_lock, 0, R.drawable.ic_visibility_off, 0
            )
        }
        isPasswordVisible = !isPasswordVisible
        passwordEditText.setSelection(passwordEditText.text.length)
    }
}
