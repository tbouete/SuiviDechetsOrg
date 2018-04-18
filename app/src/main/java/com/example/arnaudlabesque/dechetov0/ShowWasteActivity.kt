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


class ShowWasteActivity : AppCompatActivity() {
    var id = 0
    var stockMeal :StockMeals? = StockMeals()
    private lateinit var currentLine : LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_waste)

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

        stockMeal = intent.getSerializableExtra("stockMeal") as StockMeals?

        var listComposted = stockMeal!!.listSEM[stockMeal!!.listSEM.lastIndex].listElementComposted
        listComposted.forEach { elementComposted -> createElement(elementComposted,elementComposted.basicName,R.drawable.rounded_square,R.id.lCompost) }

        var listEaten = stockMeal!!.listSEM[stockMeal!!.listSEM.lastIndex].listElementEaten
        listEaten.forEach { elementEaten -> createElement(elementEaten,elementEaten.basicName,R.drawable.rounded_square,R.id.lAssiette) }

        var listFed = stockMeal!!.listSEM[stockMeal!!.listSEM.lastIndex].listElementFed
        listFed.forEach { elementFed -> createElement(elementFed,elementFed.basicName,R.drawable.rounded_square,R.id.lChien) }

        var listThrowed = stockMeal!!.listSEM[stockMeal!!.listSEM.lastIndex].listElementThrowed
        listThrowed.forEach { elementThrowed -> createElement(elementThrowed,elementThrowed.basicName,R.drawable.rounded_square,R.id.lPoubelle) }
        
        var listStocked = stockMeal!!.listSEM[stockMeal!!.listSEM.lastIndex].listElementStocked
        listStocked.forEach { elementStocked -> createElement(elementStocked,elementStocked.basicName,R.drawable.rounded_square,R.id.lFrigo) }


    }

    private fun createElement(aliment: Element, elementName: String, idBg: Int, idLayout: Int) {
        var id = 0

        currentLine = LinearLayout(this)
        currentLine.gravity = Gravity.CENTER
        currentLine.orientation =  LinearLayout.HORIZONTAL
        findViewById<LinearLayout>(idLayout).addView(currentLine)

        var roundedSquareLayout = LinearLayout(this)
        if (idBg == 0) {
            roundedSquareLayout.background = getDrawable(R.drawable.rounded_square)
        } else {
            roundedSquareLayout.background = getDrawable(idBg)
        }

        val v = Math.round(70 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        roundedSquareLayout.layoutParams = ViewGroup.LayoutParams(v, v)
        roundedSquareLayout.gravity = Gravity.CENTER
        roundedSquareLayout.tag = elementName
        var tv = TextView(this)
        tv.id = id++
        var alimentLabel = when (aliment.quantity) {
            0.25 -> "1/4 x $elementName"
            0.33 -> "1/3 x $elementName"
            0.5 -> "1/2 x $elementName"
            1.0 -> elementName
            else -> "${aliment.quantity.toString().split('.')[0]} x $elementName"
        }
        tv.text = alimentLabel
        tv.gravity = Gravity.CENTER
        tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        tv.setTextColor(Color.BLACK)
        roundedSquareLayout.addView(tv)

        currentLine.addView(roundedSquareLayout)
        val space = Space(this)
        space.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
        currentLine.addView(space)
    }
}
