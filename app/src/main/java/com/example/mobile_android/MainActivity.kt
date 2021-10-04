package com.example.mobile_android

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private var signInButton: Button? = null
    private var signUpButton: Button? = null
    private var emailTextInputLayout: TextInputLayout? = null
    private var passwordTextInputLayout: TextInputLayout? = null
    private var emailTextView: TextInputEditText? = null
    private var passwordTextView: TextInputEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailTextInputLayout = findViewById(R.id.activity_main__email_layout)
        passwordTextInputLayout = findViewById(R.id.activity_main__password_layout)
        setupSignInButton()
        setupSignUpButton()
    }

    private fun setupSignInButton() {
        signInButton = findViewById(R.id.activity_main__button_sign_in)
        emailTextView = findViewById(R.id.activity_main__email)
        passwordTextView = findViewById(R.id.activity_main__password)

        signInButton?.setOnClickListener {
            emailTextInputLayout?.error = null
            passwordTextInputLayout?.error = null

            if (emailTextView?.text.isNullOrBlank()) {
                emailTextInputLayout?.error = "Email can't be blank"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailTextView?.text.toString()).matches()) {
                emailTextInputLayout?.error = "Email is invalid "
            } else if (passwordTextView?.text.isNullOrBlank()) {
                passwordTextInputLayout?.error = "Password can't be blank"
            } else if (passwordTextView?.text.toString().length < 8) {
                passwordTextInputLayout?.error = "Password must be at least 8 characters long"
            } else {
                Toast.makeText(applicationContext, "SUCCESS", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupSignUpButton() {
        signUpButton = findViewById(R.id.activity_main__button_sign_up)
        signUpButton?.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
