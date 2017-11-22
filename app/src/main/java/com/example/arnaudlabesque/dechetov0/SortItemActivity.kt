package com.example.arnaudlabesque.dechetov0

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by arnaud.labesque on 22/11/2017.
 */

class SortItemActivity : AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sort_food)

        val selectedMeal = intent.getStringExtra("meal")

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Ajout d'un aliment pour le " + selectedMeal + " - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}