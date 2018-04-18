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
import elements.ElementFactory
import elements.StockMeals
import java.text.SimpleDateFormat
import java.util.*
import kotlin.NoSuchElementException


/**
 * Created by arnaud.labesque on 08/01/2018.
 */

class TreatItemActivity : AppCompatActivity() {
    private var stockMeal: StockMeals? = StockMeals()
    private var nbElements = 0
    private var compteur = 0
    private lateinit var currentLine: LinearLayout

    private fun createElement(aliment: Element, elementName: String, idBg: Int) {
        var id = 0
        nbElements++

        if (compteur % 5 == 0) {
            currentLine = LinearLayout(this)
            currentLine.gravity = Gravity.CENTER
            currentLine.orientation = LinearLayout.HORIZONTAL
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

        roundedSquareLayout.setOnClickListener {
            val inflater = this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popUpView = inflater.inflate(R.layout.layout_pop_up_treat_item, null)

            val tvTitrePopup = popUpView.findViewById<TextView>(R.id.tvTitrePopupTreatItem)
            tvTitrePopup.text = "Gestion de l'aliment $elementName"

            val popup = PopupWindow(popUpView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            popup.showAtLocation(findViewById<LinearLayout>(R.id.globalLayout), Gravity.BOTTOM, 0, 0)

            popUpView.findViewById<LinearLayout>(R.id.btnComposte).setOnClickListener { handleCompostedWaste(aliment, roundedSquareLayout, popup) }
            popUpView.findViewById<LinearLayout>(R.id.btnFrigo).setOnClickListener { handleStockedWaste(aliment, roundedSquareLayout, popup) }
            popUpView.findViewById<LinearLayout>(R.id.btnAssiette).setOnClickListener { handleEatenWaste(aliment, roundedSquareLayout, popup) }
            popUpView.findViewById<LinearLayout>(R.id.btnChien).setOnClickListener { handleFedWaste(aliment, roundedSquareLayout, popup) }
            popUpView.findViewById<LinearLayout>(R.id.btnPoubelle).setOnClickListener { handleThrowedWaste(aliment, roundedSquareLayout, popup) }
        }

        currentLine.addView(roundedSquareLayout)
        val space = Space(this)
        space.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
        currentLine.addView(space)
    }

    private fun handleCompostedWaste(aliment: Element, layout: LinearLayout, popup: PopupWindow) {

        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToComposted(aliment)

        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToComposted(aliment)

        layout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if (nbElements == 0) {
            var btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener {
                var myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent, 0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }

    private fun handleStockedWaste(aliment: Element, layout: LinearLayout, popup: PopupWindow) {
        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToStocked(aliment)

        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToStocked(aliment)
        layout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if (nbElements == 0) {
            val btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener {
                val myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent, 0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }

    private fun handleFedWaste(aliment: Element, layout: LinearLayout, popup: PopupWindow) {
        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToFed(aliment)

        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToFed(aliment)
        layout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if (nbElements == 0) {
            val btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener {
                val myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent, 0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }

    private fun handleEatenWaste(aliment: Element, layout: LinearLayout, popup: PopupWindow) {

        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToEaten(aliment)


        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToEaten(aliment)
        layout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if (nbElements == 0) {
            val btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener {
                val myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent, 0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }

    private fun handleThrowedWaste(aliment: Element, layout: LinearLayout, popup: PopupWindow) {
        stockMeal!!.listSEM!![stockMeal!!.listSEM.lastIndex]!!.addToThrowed(aliment)

        //stockMeal.listSEM[stockMeal.listSEM.lastIndex].addToThrowed(aliment)
        layout.visibility = View.INVISIBLE
        popup.dismiss()
        nbElements--
        if (nbElements == 0) {
            val btnValidate = Button(this)
            btnValidate.text = "Valider"
            btnValidate.background = getDrawable(R.drawable.green_button_border)
            btnValidate.setOnClickListener {
                val myIntent = Intent(this, MealCompositionActivity::class.java)
                myIntent.putExtra("stockMeal", stockMeal)
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                finish()
                startActivityIfNeeded(myIntent, 0)
            }
            findViewById<LinearLayout>(R.id.treatableItem).addView(btnValidate)
        }
    }

    private fun treatItem() {
        val aliments = intent.getSerializableExtra("items") as ArrayList<Element>
        val idBG = intent.getIntExtra("idColorBG", 0)
        stockMeal = intent.getSerializableExtra("stockMeal") as StockMeals?
        var factory = ElementFactory()
        for (aliment in aliments) when (aliment.quantity) {
            0.25 -> {
                createElement(aliment, aliment.basicName, idBG)
                try {
                    createElement(factory.copyElement(aliment), aliment.basicName, idBG)
                    createElement(factory.copyElement(aliment), aliment.basicName, idBG)
                    createElement(factory.copyElement(aliment), aliment.basicName, idBG)
                } catch (e : Exception) {}
            }
            0.33 -> {
                createElement(aliment, aliment.basicName, idBG)
                try {
                    createElement(factory.copyElement(aliment), aliment.basicName, idBG)
                    createElement(factory.copyElement(aliment), aliment.basicName, idBG)
                } catch (e : Exception) {}
            }
            0.5 -> {
                createElement(aliment, aliment.basicName, idBG)
                try {
                    createElement(factory.copyElement(aliment), aliment.basicName, idBG)
                } catch (e : Exception) {}
            }
            else -> {
                createElement(aliment, aliment.basicName, idBG)
             }
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

        createElement(recipe, recipe.basicName, 0)

        val aliments = intent.getSerializableExtra("items") as ArrayList<Element>

        var factory = ElementFactory()

        for (aliment in aliments) when (aliment.quantity) {
            0.25 -> {
                createElement(aliment, aliment.basicName, 0)
                try {
                    createElement(factory.copyElement(aliment), aliment.basicName, 0)
                    createElement(factory.copyElement(aliment), aliment.basicName, 0)
                    createElement(factory.copyElement(aliment), aliment.basicName, 0)
                } catch (e: Exception) {
                }
            }
            0.33 -> {
                createElement(aliment, aliment.basicName, 0)
                try {
                    createElement(factory.copyElement(aliment), aliment.basicName, 0)
                    createElement(factory.copyElement(aliment), aliment.basicName, 0)
                } catch (e: Exception) {
                }
            }
            0.5 -> {
                createElement(aliment, aliment.basicName, 0)
                try {
                    createElement(factory.copyElement(aliment), aliment.basicName, 0)
                } catch (e: Exception) {
                }
            }
            else -> {
                createElement(aliment, aliment.basicName, 0)
            }
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

    private fun checkWaste(aliment: Element, idBG: Int) {

        if (aliment.isGeneratingBone) {
            createElement(aliment, "Os de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingCore) {
            when (aliment.basicName) {
                "Pomme" -> createElement(aliment, "Trognon de " + aliment.basicName, idBG)
                "Poire" -> createElement(aliment, "Trognon de " + aliment.basicName, idBG)
                "Ananas" -> createElement(aliment, "Trognon d' " + aliment.basicName, idBG)
                else -> createElement(aliment, "Noyau de " + aliment.basicName, idBG)
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

        if (intent.getBooleanExtra("isRecipe", false)) {
            treatRecipe()
        } else {
            treatItem()
        }

    }

}
