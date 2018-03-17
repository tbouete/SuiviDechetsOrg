package com.example.arnaudlabesque.dechetov0

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import elements.Element
import elements.StockMeals
import java.io.ObjectInputStream
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by ferre on 09/03/2018.
 */


class ShowWasteActivity() : AppCompatActivity() {
    var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_waste)
        var stockMeal = StockMeals()

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Historique du repas"
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        findViewById<View>(R.id.btnCancelTreat).setOnClickListener {
            finish()
        }

        findViewById<View>(R.id.itemSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        stockMeal = intent.getSerializableExtra("stockMeal") as StockMeals

        var listComposted = stockMeal.listSEM.get( stockMeal.listSEM.lastIndex ).listElementComposted
        var currentLine = LinearLayout(this)

        val lCompost = findViewById<LinearLayout>(R.id.lCompost)
        val lAssiette = findViewById<LinearLayout>(R.id.lAssiette)
        val lChien = findViewById<LinearLayout>(R.id.lChien)
        val lPoubelle = findViewById<LinearLayout>(R.id.lPoubelle)
        val lFrigo = findViewById<LinearLayout>(R.id.lFrigo)

        Log.d("test",listComposted.toString())
        for (elementCompost in listComposted) {
            Log.d("test2",elementCompost.toString())
            var linearLayout = LinearLayout(this)
            linearLayout.background = getDrawable(R.drawable.rounded_square)
            val v = Math.round(70 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
            linearLayout.layoutParams = ViewGroup.LayoutParams(v, v)
            linearLayout.orientation = LinearLayout.VERTICAL
            linearLayout.gravity = Gravity.CENTER

            var tv = TextView(this)
            tv.id = id++
            tv.text = elementCompost.toString()
            tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            tv.gravity = Gravity.CENTER
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
            tv.setTextColor(Color.BLACK)
            linearLayout.addView(tv)

            currentLine.addView(linearLayout)

            var space = Space(this)
            space.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
            currentLine.addView(space)

            lCompost.addView(currentLine)
        }


    }
}