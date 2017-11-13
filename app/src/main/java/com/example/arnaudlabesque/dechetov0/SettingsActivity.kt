package com.example.arnaudlabesque.dechetov0

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import java.text.SimpleDateFormat
import java.util.*


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btn = findViewById<Button>(R.id.buttonSwitchActivity)

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Paramètrage de l'application - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-"," ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN



        btn.setOnClickListener{
            val intent = Intent(this,SelectMealActivity::class.java)
            startActivity(intent)
        }


    }

}
