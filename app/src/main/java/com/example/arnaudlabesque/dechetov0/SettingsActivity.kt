package com.example.arnaudlabesque.dechetov0

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.*
import elements.StockElementMeal
import elements.StockMeals
import kotlinx.android.synthetic.main.activity_select_meal.view.*
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.text.SimpleDateFormat
import java.util.*


class SettingsActivity : AppCompatActivity() {

    var sharedPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Paramètrage de l'application - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        sharedPref = applicationContext.getSharedPreferences("com.example.arnaudlabesque.dechetov0.prefs", Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        val spinnerAnimal = findViewById<Spinner>(R.id.spinner)
        val switchNotif = findViewById<Switch>(R.id.notif)
        val switchPotager = findViewById<Switch>(R.id.potager)
        val cbPetitDej = findViewById<CheckBox>(R.id.checkBoxPetitDej)
        val cbEncas = findViewById<CheckBox>(R.id.checkBoxEncas)
        val cbDej = findViewById<CheckBox>(R.id.checkBoxDej)
        val cbGouter = findViewById<CheckBox>(R.id.checkBoxGouter)
        val cbDiner = findViewById<CheckBox>(R.id.checkBoxDiner)

        val btn = findViewById<View>(R.id.buttonSwitchActivity)
        val strSP = sharedPref!!.getString("animal", "Animaux domestiques")
        if (strSP != null && strSP.isNotEmpty()) {
            val myarray = resources.getStringArray(R.array.animals)
            for (i in myarray.indices) {
                if (myarray[i] == strSP) {
                    spinnerAnimal.setSelection(i)
                }
            }
        }

        if (sharedPref!!.getBoolean("petitDej", false)) {
            cbPetitDej.isChecked = true
        }
        if (sharedPref!!.getBoolean("encas", false)) {
            cbEncas.isChecked = true
        }
        if (sharedPref!!.getBoolean("dej", false)) {
            cbDej.isChecked = true
        }
        if (sharedPref!!.getBoolean("gouter", false)) {
            cbGouter.isChecked = true
        }
        if (sharedPref!!.getBoolean("diner", false)) {
            cbDiner.isChecked = true
        }
        if (sharedPref!!.getBoolean("notif", false)) {
            switchNotif.isChecked = true
        }
        if (sharedPref!!.getBoolean("potager", false)) {
            switchPotager.isChecked = true
        }

        btn.setOnClickListener {

            editor?.putString("animal", spinnerAnimal.selectedItem.toString())
            editor?.putBoolean("notif", switchNotif.isChecked)
            editor?.putBoolean("potager", switchPotager.isChecked)
            editor?.putBoolean("petitDej", cbPetitDej.isChecked)
            editor?.putBoolean("encas", cbEncas.isChecked)
            editor?.putBoolean("dej", cbDej.isChecked)
            editor?.putBoolean("gouter", cbGouter.isChecked)
            editor?.putBoolean("diner", cbDiner.isChecked)


            editor?.commit()

            finish()
        }

        findViewById<View>(R.id.buttonCancelSettings).setOnClickListener {
            finish()
        }

    }

}
