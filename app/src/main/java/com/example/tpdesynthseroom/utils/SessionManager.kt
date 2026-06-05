package com.example.tpdesynthseroom.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("session_prefs", Context.MODE_PRIVATE)

    fun login(email: String, password: String): Boolean {

        val valid = (email == "admin@gmail.com" && password == "1234")

        if (valid) {
            prefs.edit().putBoolean("is_logged_in", true).apply()
        }

        return valid
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean("is_logged_in", false)

    fun logout() = prefs.edit().putBoolean("is_logged_in", false).apply()
}