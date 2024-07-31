package com.sylvia.sylvia_lab3.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.sylvia.sylvia_lab3.R

class LoginActivity : AppCompatActivity() {
    private lateinit var nurseIdInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        nurseIdInput = findViewById(R.id.nurseIdInput)
        passwordInput = findViewById(R.id.passwordInput)
        loginButton = findViewById(R.id.buttonLogin)

        loginButton.setOnClickListener {
            val nurseId = nurseIdInput.text.toString().toInt()
            val password = passwordInput.text.toString()
            val sharedPreferences = getSharedPreferences("HospitalPrefs", MODE_PRIVATE)
            sharedPreferences.edit().putInt("NURSE_ID", nurseId).apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}