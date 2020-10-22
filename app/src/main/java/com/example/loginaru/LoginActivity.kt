package com.example.loginaru

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)
        if (sharedPreferences.getString("username", "")?.isNotEmpty()!!) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        setContentView(R.layout.activity_login)
    }

    fun onClick(view: View) {
        val username = email.text.toString()
        val password = password.text.toString()
        if (username.isNotEmpty() && password.isNotEmpty()) {
            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("password", password)
            editor.apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
