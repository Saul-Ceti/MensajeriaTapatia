package com.example.mensajeriatapatia

import android.content.Context
import android.content.SharedPreferences

open class Usuario(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserData", Context.MODE_PRIVATE)

    // Agregar el campo del nivel de acceso
    fun saveCredentials(name: String, age: Int, email: String, password: String, isAdmin: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putInt("age", age)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.putBoolean("isAdmin", isAdmin)
        editor.apply()
    }

    fun getName(): String? {
        return sharedPreferences.getString("name", null)
    }

    fun getAge(): Int? {
        return sharedPreferences.getInt("age", 0)
    }

    fun getEmail(): String? {
        return sharedPreferences.getString("email", null)
    }

    fun getPassword(): String? {
        return sharedPreferences.getString("password", null)
    }

    // Nuevo método para obtener el nivel de acceso
    fun isAdmin(): Boolean {
        return sharedPreferences.getBoolean("isAdmin", false)
    }
}
