package com.example.mensajeriatapatia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SigninActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var backButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // Inicializa los elementos de la interfaz
        nameEditText = findViewById(R.id.edtSignName)
        ageEditText = findViewById(R.id.edtSignAge)
        emailEditText = findViewById(R.id.edtSignEmail)
        passwordEditText = findViewById(R.id.edtSignPassword)
        backButton = findViewById(R.id.btnSignBack)
        registerButton = findViewById(R.id.btnSignRegister)

        val user = Usuario(this)

        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val ageText = ageEditText.text.toString()
            val age = ageText.toIntOrNull() ?: 0
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (name == null || age == 0 || email == null || password == null) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                user.saveCredentials(name, age, email, password, false)
                Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}