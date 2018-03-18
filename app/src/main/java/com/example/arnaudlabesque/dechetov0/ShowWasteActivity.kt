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
        for (elementComposted in listComposted) {
            createElement(elementComposted,elementComposted.basicName,R.drawable.rounded_square,R.id.lCompost)
        }
        var listEaten = stockMeal!!.listSEM[stockMeal!!.listSEM.lastIndex].listElementEaten
        for (elementEaten in listEaten) {
            createElement(elementEaten,elementEaten.basicName,R.drawable.rounded_square,R.id.lAssiette)
        }
        var listFed = stockMeal!!.listSEM[stockMeal!!.listSEM.lastIndex].listElementFed
        for (elementFed in listFed) {
            createElement(elementFed,elementFed.basicName,R.drawable.rounded_square,R.id.lChien)
        }
        var listThrowed = stockMeal!!.listSEM[stockMeal!!.listSEM.lastIndex].listElementThrowed
        for (elementThrowed in listThrowed) {
            createElement(elementThrowed,elementThrowed.basicName,R.drawable.rounded_square,R.id.lPoubelle)
        }
        var listStocked = stockMeal!!.listSEM[stockMeal!!.listSEM.lastIndex].listElementStocked
        for (elementStocked in listStocked) {
            createElement(elementStocked,elementStocked.basicName,R.drawable.rounded_square,R.id.lFrigo)
        }


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
        tv.text = elementName
        tv.gravity = Gravity.CENTER
        tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        tv.setTextColor(Color.BLACK)
        roundedSquareLayout.addView(tv)

        currentLine.addView(roundedSquareLayout)
        val space = Space(this)
        space.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
        currentLine.addView(space)
    }



    private fun checkWaste(aliment : Element, idBG : Int, idLayout: Int) {

        if (aliment.isGeneratingBone) {
            createElement(aliment, "Os de " + aliment.basicName, idBG, idLayout)
        }
        if (aliment.isGeneratingCore) {
            when (aliment.basicName){
                "Pomme" -> createElement(aliment, "Trognon de " + aliment.basicName, idBG, idLayout)
                "Poire" -> createElement(aliment, "Trognon de " + aliment.basicName, idBG, idLayout)
                "Ananas" -> createElement(aliment, "Trognon d' " + aliment.basicName, idBG, idLayout)
                else ->createElement(aliment, "Noyau de " + aliment.basicName, idBG, idLayout)
            }
        }

        if (aliment.isGeneratingCrust) {
            createElement(aliment, "Croûte de " + aliment.basicName, idBG, idLayout)
        }
        if (aliment.isGeneratingFat) {
            createElement(aliment, "Gras de " + aliment.basicName, idBG, idLayout)
        }
        if (aliment.isGeneratingFilter) {
            createElement(aliment, "Filtre de " + aliment.basicName, idBG, idLayout)
        }
        if (aliment.isGeneratingPeel) {
            createElement(aliment, "Peau de " + aliment.basicName, idBG, idLayout)
        }
        if (aliment.isGeneratingMeatSkin) {
            createElement(aliment, "Peau de " + aliment.basicName, idBG, idLayout)
        }
        if (aliment.isGeneratingTail) {
            createElement(aliment, "Queue de " + aliment.basicName, idBG, idLayout)
        }
    }
}
