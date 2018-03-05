package com.example.arnaudlabesque.dechetov0

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import elements.ComposedElement
import elements.Element
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by arnaud.labesque on 09/01/2018.
 */

class CreateRecipeActivity : AppCompatActivity() {

    private var recette = ComposedElement(null,1.0,true,false,false,ArrayList<Element>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_recipe)

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Création du plat - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        findViewById<View>(R.id.itemSettings).setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        val lButtonAddElement = findViewById<View>(R.id.lAjoutAlimentToRecipe)
        lButtonAddElement.setOnClickListener {
            val intentRecipe = Intent(this, FoodChoiceActivity::class.java)
            intentRecipe.putExtra("recipe", true)
            startActivityForResult(intentRecipe, 7)
        }

        findViewById<Button>(R.id.buttonValidateRecipe).setOnClickListener {
            recette.basicName = (findViewById<View>(R.id.etRecipeName) as EditText).text.toString()
        }

        findViewById<View>(R.id.lCancel).setOnClickListener{
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data : Intent? ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 7) {
            if (resultCode == Activity.RESULT_OK) {
                val lAlimentRecipe = findViewById<LinearLayout>(R.id.lAlimentRecipe)
                val aliment = data?.getSerializableExtra("item") as Element
                val idBG = data?.getIntExtra("idColorBG",0)

                var tv = TextView(this)
                tv.text = aliment.basicName
                tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                tv.setTextColor(Color.BLACK)
                lAlimentRecipe.addView(tv)

                recette.composition.add(aliment)
            }
        }
    }
}