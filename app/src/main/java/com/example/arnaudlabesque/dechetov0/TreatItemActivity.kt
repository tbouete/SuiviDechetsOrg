package com.example.arnaudlabesque.dechetov0

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TableLayout
import android.widget.TextView
import elements.Element
import elements.ElementFactory
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by arnaud.labesque on 08/01/2018.
 */

class TreatItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treat_item)

        val lTreatableItem = findViewById<View>(R.id.treatableItem) as LinearLayout

        val aliment = intent.getSerializableExtra("item") as Element
        val idBG = intent.getIntExtra("idColorBG",0)
        createElement(aliment.basicName, idBG)

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Traitement de l'aliment "+ aliment.basicName +" - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        findViewById<View>(R.id.itemSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        if (aliment.isGeneratingBone)     { createElement("Os de "+aliment.basicName,idBG) }
        if (aliment.isGeneratingCore)     { createElement("Noyau de "+aliment.basicName,idBG) }
        if (aliment.isGeneratingCrust)    { createElement("Croute de "+aliment.basicName,idBG) }
        if (aliment.isGeneratingFat)      { createElement("Gras de "+aliment.basicName,idBG) }
        if (aliment.isGeneratingFilter)   { createElement("Filtre de "+aliment.basicName,idBG) }
        if (aliment.isGeneratingPeel)     { createElement("Peau de "+aliment.basicName,idBG) }
        if (aliment.isGeneratingMeatSkin) { createElement("Peau de "+aliment.basicName,idBG) }
        if (aliment.isGeneratingTail)     { createElement("Queue de "+aliment.basicName,idBG) }

    }

    fun createElement(elementName : String,idBg:Int){
        var id = 0
        var currentLine = LinearLayout(this)
        currentLine.gravity = Gravity.CENTER
        findViewById<LinearLayout>(R.id.treatableItem).addView(currentLine)

            //Log.d("test",element)
            var linearLayout = LinearLayout(this)
        if(idBg==0){
            linearLayout.background=getDrawable(R.drawable.rounded_square)
        }else{
            linearLayout.background=getDrawable(idBg)
        }
            val v =Math.round(100*(this.resources.displayMetrics.xdpi/ DisplayMetrics.DENSITY_DEFAULT))
            linearLayout.layoutParams= ViewGroup.LayoutParams(v, v)
            linearLayout.gravity = Gravity.CENTER
            var tv = TextView(this)
            tv.id = id++
            tv.text = elementName
            tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            tv.setTextColor(Color.BLACK)
            linearLayout.addView(tv)


            currentLine.addView(linearLayout)
            var space = Space(this)
            space.layoutParams = TableLayout.LayoutParams(0,Math.round(1*(this.resources.displayMetrics.xdpi/ DisplayMetrics.DENSITY_DEFAULT)),1f)
            currentLine.addView(space)

    }
}