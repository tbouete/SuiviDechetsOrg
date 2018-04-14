package com.example.arnaudlabesque.dechetov0

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.DisplayMetrics
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import elements.ComposedElement
import elements.Element
import elements.StockMeals
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by arnaud.labesque on 08/01/2018.
 */

class TreatItemActivity : AppCompatActivity() {
    private var stockMeal :StockMeals? = StockMeals()
    private var nbElements = 0
    private var compteur = 0
    private lateinit var currentLine : LinearLayout

    private fun createElement(aliment: Element, elementName: String, idBg: Int) {
        var id = 0
        nbElements++

        if(compteur % 5 == 0) {
            currentLine = LinearLayout(this)
            currentLine.gravity = Gravity.CENTER
            currentLine.orientation =  LinearLayout.HORIZONTAL
            findViewById<LinearLayout>(R.id.treatableItem).addView(currentLine)
        }

        compteur++



        var roundedSquareLayout = LinearLayout(this)
        if (idBg == 0) {
            roundedSquareLayout.background = getDrawable(R.drawable.rounded_square)
        } else {
            roundedSquareLayout.background = getDrawable(idBg)
        }

        val v = Math.round(100 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        roundedSquareLayout.layoutParams = ViewGroup.LayoutParams(v, v)
        roundedSquareLayout.gravity = Gravity.CENTER
        roundedSquareLayout.tag = 1
        var tv = TextView(this)
        tv.id = id++
        tv.text = elementName
        tv.gravity = Gravity.CENTER
        tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        tv.setTextColor(Color.BLACK)
        roundedSquareLayout.addView(tv)

        roundedSquareLayout.setOnClickListener {
            val inflater = this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popUpView = inflater.inflate(R.layout.layout_pop_up_treat_item, null)

            val tvTitrePopup = popUpView.findViewById<TextView>(R.id.tvTitrePopupTreatItem)
            tvTitrePopup.text = "Gestion de l'aliment $elementName"

            var values = arrayOf("1/4","1/3","1/2","1")
            var numberpicker = popUpView.findViewById<NumberPicker>(R.id.treatPicker)
            numberpicker.minValue = 0
            numberpicker.maxValue = (values.size - 1)
            numberpicker.wrapSelectorWheel = false

            numberpicker.displayedValues = values
            var valQuantite = numberpicker.value

            val popup = PopupWindow(popUpView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            popup.showAtLocation(findViewById<LinearLayout>(R.id.globalLayout), Gravity.BOTTOM, 0, 0)

            popUpView.findViewById<LinearLayout>(R.id.btnComposte).setOnClickListener{handleCompostedWaste(aliment,roundedSquareLayout,popup,convertString2Double(values[valQuantite]))}
            popUpView.findViewById<LinearLayout>(R.id.btnFrigo).setOnClickListener{handleStockedWaste(aliment,roundedSquareLayout,popup,convertString2Double(values[valQuantite]))}
            popUpView.findViewById<LinearLayout>(R.id.btnAssiette).setOnClickListener{handleEatenWaste(aliment,roundedSquareLayout,popup,convertString2Double(values[valQuantite]))}
            popUpView.findViewById<LinearLayout>(R.id.btnChien).setOnClickListener{handleFedWaste(aliment,roundedSquareLayout,popup,convertString2Double(values[valQuantite]))}
            popUpView.findViewById<LinearLayout>(R.id.btnPoubelle).setOnClickListener{handleThrowedWaste(aliment,roundedSquareLayout,popup,convertString2Double(values[valQuantite]))}
        }

        currentLine.addView(roundedSquareLayout)
        val space = Space(this)
        space.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
        currentLine.addView(space)
    }

    private fun handleCompostedWaste(aliment: Element, layout: LinearLayout, popup : PopupWindow, quantite : Double){

        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToComposted(aliment)

        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToComposted(aliment)

        layout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if(nbElements==0){
            var btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener{
                var myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent,0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }
    private fun handleStockedWaste(aliment: Element, layout: LinearLayout, popup : PopupWindow, quantite : Double){
        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToStocked(aliment)

        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToStocked(aliment)
        layout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if(nbElements==0){
            val btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener{
                val myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent,0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }
    private fun handleFedWaste(aliment: Element, layout: LinearLayout, popup : PopupWindow, quantite : Double){
        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToFed(aliment)

        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToFed(aliment)
        layout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if(nbElements==0){
            val btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener{
                val myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent,0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }
    private fun handleEatenWaste(aliment: Element, layout: LinearLayout, popup : PopupWindow, quantite : Double){
        var diff =(layout.tag as Int)-quantite
        if (diff == 0.0){
            for (i in 0..layout.childCount){
                if(layout.getChildAt(i) is TextView){
                    (layout.getChildAt(i)as TextView).text = "" + (1-quantite) + " " +(layout.getChildAt(i)as TextView).text
                    (layout.getChildAt(i)as TextView).tag = (1-quantite)
                }
            }
        }

        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToEaten(aliment)


        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToEaten(aliment)
        //alayout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if(nbElements==0){
            val btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener{
                val myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent,0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }
    private fun handleThrowedWaste(aliment: Element, layout: LinearLayout, popup : PopupWindow, quantite : Double){
        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToThrowed(aliment)

        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToThrowed(aliment)
        layout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if(nbElements==0){
            val btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener{
                val myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent,0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }

    private fun treatItem() {
        val aliments = intent.getSerializableExtra("items") as ArrayList<Element>
        val idBG = intent.getIntExtra("idColorBG", 0)
        stockMeal = intent.getSerializableExtra("stockMeal") as StockMeals?
        for(aliment in aliments){
            createElement(aliment, aliment.basicName, idBG)
        }


        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Traitement de l'aliment " + aliments[aliments.lastIndex].basicName + " - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        findViewById<View>(R.id.itemSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        findViewById<View>(R.id.btnCancelTreat).setOnClickListener {
            finish()
        }

    }

    private fun treatRecipe() {
        val recipe = intent.getSerializableExtra("recipe") as ComposedElement
        stockMeal = intent.getSerializableExtra("stockMeal") as StockMeals

        createElement(recipe, recipe.basicName,0)

        val aliments = intent.getSerializableExtra("items") as ArrayList<Element>
        for(aliment in aliments){
            createElement(aliment, aliment.basicName, 0)
        }

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Traitement de la recette " + recipe.basicName + " - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        findViewById<View>(R.id.itemSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        findViewById<View>(R.id.btnCancelTreat).setOnClickListener {
            finish()
        }



    }

    private fun checkWaste(aliment : Element, idBG : Int) {

        if (aliment.isGeneratingBone) {
            createElement(aliment, "Os de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingCore) {
            when (aliment.basicName){
                "Pomme" -> createElement(aliment, "Trognon de " + aliment.basicName, idBG)
                "Poire" -> createElement(aliment, "Trognon de " + aliment.basicName, idBG)
                "Ananas" -> createElement(aliment, "Trognon d' " + aliment.basicName, idBG)
                else ->createElement(aliment, "Noyau de " + aliment.basicName, idBG)
            }
        }

        if (aliment.isGeneratingCrust) {
            createElement(aliment, "Croûte de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingFat) {
            createElement(aliment, "Gras de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingFilter) {
            createElement(aliment, "Filtre de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingPeel) {
            createElement(aliment, "Peau de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingMeatSkin) {
            createElement(aliment, "Peau de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingTail) {
            createElement(aliment, "Queue de " + aliment.basicName, idBG)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treat_item)

        if(intent.getBooleanExtra("isRecipe", false)) {
            treatRecipe()
        } else {
            treatItem()
        }

    }

    private fun convertString2Double (str : String): Double =
            when (str){
                "1/4" -> 0.25
                "1/3" -> 0.33
                "1/2" -> 0.5
                "1" -> 1.0
                else -> 1.0
            }

}
