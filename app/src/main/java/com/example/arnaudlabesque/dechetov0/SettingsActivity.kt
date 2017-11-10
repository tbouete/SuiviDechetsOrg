package com.example.arnaudlabesque.dechetov0

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btn = findViewById<Button>(R.id.buttonSwitchActivity)

        btn.setOnClickListener{
            val intent = Intent(this,SelectMealActivity::class.java)
            startActivity(intent)
        }
    }
}
