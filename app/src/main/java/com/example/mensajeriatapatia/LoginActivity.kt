package com.example.mensajeriatapatia

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Texto de otro color
        val signinTextView = findViewById<TextView>(R.id.txtSignin)

        val textoCompleto = "¿No tienes cuenta? Regístrate"

        // Crear una SpannableString
        val spannableString = SpannableString(textoCompleto)

        // Índices del texto que quieres resaltar
        val startIndex = textoCompleto.indexOf("Regístrate")
        val endIndex = startIndex + "Regístrate".length

        // Aplicar estilo de color
        spannableString.setSpan(ForegroundColorSpan(resources.getColor(R.color.titles)), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Aplicar estilo negrita
        spannableString.setSpan(StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Configurar el texto en el TextView
        signinTextView.text = spannableString

        // Inicializa los elementos de la interfaz
        usernameEditText = findViewById(R.id.edtUsername)
        passwordEditText = findViewById(R.id.edtPassword)
        loginButton = findViewById(R.id.btnLoginEntry)
        exitButton = findViewById(R.id.btnLoginExit)

        // Asigna un listener al botón de inicio de sesión
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (checkCredentials(username, password)) {
                // Las credenciales son válidas, inicia sesión
                // Puedes redirigir a otra actividad o realizar alguna acción aquí.
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                // Las credenciales son incorrectas, muestra un mensaje de error.
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

        // Asigna un listener al botón de salida
        exitButton.setOnClickListener {
            finish() // Cierra la actividad de inicio de sesión
        }
    }

    private fun checkCredentials(username: String, password: String): Boolean {
        // Aquí debes verificar las credenciales.
        // Puedes utilizar SharedPreferences para compararlas con las credenciales almacenadas.

        // Supongamos que tienes una clase UserPreferences para manejar SharedPreferences.
        val userPreferences = Usuario(this)
        val savedUsername = userPreferences.getEmail()
        val savedPassword = userPreferences.getPassword()

        // Verifica si las credenciales coinciden con las almacenadas en SharedPreferences.
        return username == savedUsername && password == savedPassword
    }

    fun gotoSignin(view: View) {
        val intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
    }
}