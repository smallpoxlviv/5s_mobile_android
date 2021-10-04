package com.example.mobile_android

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {

    private var signUpButton: Button? = null
    private var nameTextInputLayout: TextInputLayout? = null
    private var emailTextInputLayout: TextInputLayout? = null
    private var passwordTextInputLayout: TextInputLayout? = null
    private var confirmPasswordTextInputLayout: TextInputLayout? = null
    private var nameTextView: TextInputEditText? = null
    private var emailTextView: TextInputEditText? = null
    private var passwordTextView: TextInputEditText? = null
    private var confirmPasswordTextView: TextInputEditText? = null

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        nameTextInputLayout = findViewById(R.id.activity_sign_up__name_layout)
        emailTextInputLayout = findViewById(R.id.activity_sign_up__email_layout)
        passwordTextInputLayout = findViewById(R.id.activity_sign_up__password_layout)
        confirmPasswordTextInputLayout = findViewById(R.id.activity_sign_up__confirm_password_layout)

        toolbar = findViewById(R.id.activity_sign_up__toolbar)
        toolbar?.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        setupSignUpButton()
    }

    private fun setupSignUpButton() {
        signUpButton = findViewById(R.id.activity_sign_up__button_sign_up)
        nameTextView = findViewById(R.id.activity_sign_up__name)
        emailTextView = findViewById(R.id.activity_sign_up__email)
        passwordTextView = findViewById(R.id.activity_sign_up__password)
        confirmPasswordTextView = findViewById(R.id.activity_sign_up__confirm_password)

        signUpButton?.setOnClickListener {
            nameTextInputLayout?.error = null
            emailTextInputLayout?.error = null
            passwordTextInputLayout?.error = null
            confirmPasswordTextInputLayout?.error = null

            if (nameTextView?.text.isNullOrBlank()) {
                nameTextInputLayout?.error = "Name can't be blank"
            } else if (emailTextView?.text.isNullOrBlank()) {
                emailTextInputLayout?.error = "Email can't be blank"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailTextView?.text.toString()).matches()) {
                emailTextInputLayout?.error = "Email is invalid "
            } else if (passwordTextView?.text.isNullOrBlank()) {
                passwordTextInputLayout?.error = "Password can't be blank"
            } else if (passwordTextView?.text.toString().length < 8) {
                passwordTextInputLayout?.error = "Password must be at least 8 characters long"
            } else if (confirmPasswordTextView?.text.toString() != passwordTextView?.text.toString()) {
                passwordTextInputLayout?.error = "Passwords are different"
                confirmPasswordTextInputLayout?.error = "Passwords are different"
            } else {
                Toast.makeText(applicationContext, "SUCCESS", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
