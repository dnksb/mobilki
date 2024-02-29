package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class congretulations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congretulations)
        val retry = this.findViewById<Button>(R.id.button);

        retry.setOnClickListener {
            val intent = Intent(this@congretulations, MainActivity::class.java)
            startActivity(intent)
        }
    }
}