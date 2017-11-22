package com.example.arnaudlabesque.dechetov0

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.annotation.Dimension
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_select_item.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by arnaud.labesque on 20/11/2017.
 */

class SelectItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_item)


        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = intent.getStringExtra("titre") + " - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        findViewById<View>(R.id.itemSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        if(intent.getStringExtra("categorie")=="Legume"){
            createElements(R.array.legumes,R.drawable.rounded_square_legume)
        }else if(intent.getStringExtra("categorie")=="Fruit"){
            createElements(R.array.fruits,R.drawable.rounded_square_fruit)
        }else if(intent.getStringExtra("categorie")=="Feculent"){
            createElements(R.array.feculents,R.drawable.rounded_square_feculent)
        }else if(intent.getStringExtra("categorie")=="Laitage"){
            createElements(R.array.laitages,R.drawable.rounded_square_laitage)
        }else if(intent.getStringExtra("categorie")=="Patisserie"){
            createElements(R.array.patisseries,R.drawable.rounded_square_patisserie)
        }else if(intent.getStringExtra("categorie")=="Sauce"){
            createElements(R.array.sauces,R.drawable.rounded_square_sauce)
        }else if(intent.getStringExtra("categorie")=="Viande"){
            createElements(R.array.viandes,R.drawable.rounded_square_viande)
        }else if(intent.getStringExtra("categorie")=="Autre"){
            createElements(R.array.autres,R.drawable.rounded_square_autre)
        }




    }

    fun createElements(idArray:Int,idBg:Int){
        val myarray = resources.getStringArray(idArray)
        var id = 0
        var nbLeg = 0
        var currentLine = LinearLayout(this)
        currentLine.gravity = Gravity.CENTER
        findViewById<LinearLayout>(R.id.globalLayout).addView(currentLine)

        for (legume in myarray){
            var linearLayout = LinearLayout(this)
            linearLayout.background=getDrawable(idBg)
            val v =Math.round(100*(this.resources.displayMetrics.xdpi/DisplayMetrics.DENSITY_DEFAULT))
            linearLayout.layoutParams= ViewGroup.LayoutParams(v, v)
            linearLayout.gravity = Gravity.CENTER
            var tv = TextView(this)
            tv.id = id++
            tv.text = legume
            tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            tv.setTextColor(Color.BLACK)
            linearLayout.addView(tv)
            if(nbLeg%5 == 0) {
                var myspace = Space(this)
                myspace.layoutParams = TableLayout.LayoutParams(0,Math.round(1*(this.resources.displayMetrics.xdpi/DisplayMetrics.DENSITY_DEFAULT)),1f)
                currentLine.addView(myspace,0)
                currentLine = LinearLayout(this)
                findViewById<LinearLayout>(R.id.globalLayout).addView(currentLine)
                currentLine.gravity = Gravity.CENTER
            }
            currentLine.addView(linearLayout)
            var space = Space(this)
            space.layoutParams = TableLayout.LayoutParams(0,Math.round(1*(this.resources.displayMetrics.xdpi/DisplayMetrics.DENSITY_DEFAULT)),1f)
            currentLine.addView(space)
            nbLeg++
        }
        var myfinalspace = Space(this)
        myfinalspace.layoutParams = TableLayout.LayoutParams(0,Math.round(1*(this.resources.displayMetrics.xdpi/DisplayMetrics.DENSITY_DEFAULT)),1f)
        currentLine.addView(myfinalspace,0)
    }
}