package com.example.arnaudlabesque.dechetov0

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import elements.Element
import java.text.SimpleDateFormat
import java.util.*

/**
* Created by arnaud.labesque on 17/11/2017.
*/
class FoodChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_choice)

        var selectedMeal = ""

        if (intent.getBooleanExtra("recipe", false)) {
            selectedMeal = " : " + intent.getStringExtra("recipeName")
        } else {
            selectedMeal = " le " + intent.getStringExtra("meal")
        }
        val isRecipe = intent.getBooleanExtra("recipe",false)

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Ajout d'un aliment pour" + selectedMeal + " - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        findViewById<View>(R.id.itemSettings).setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }



        findViewById<LinearLayout>(R.id.btnFruit).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Fruit")
            intentSIA.putExtra("titre", "Ajout d'un fruit")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            intentSIA.putExtra("recipe",isRecipe)
            if(isRecipe){
                startActivityForResult(intentSIA,7)
            }else{
                startActivity(intentSIA)
            }
        }

        findViewById<LinearLayout>(R.id.btnLegume).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Legume")
            intentSIA.putExtra("titre", "Ajout d'un légume")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            intentSIA.putExtra("recipe",isRecipe)
            if(isRecipe){
                startActivityForResult(intentSIA,7)
            }else{
                startActivity(intentSIA)
            }
        }

        findViewById<LinearLayout>(R.id.btnFeculent).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Feculent")
            intentSIA.putExtra("titre", "Ajout d'un féculent")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            intentSIA.putExtra("recipe",isRecipe)
            if(isRecipe){
                startActivityForResult(intentSIA,7)
            }else{
                startActivity(intentSIA)
            }        }

        findViewById<LinearLayout>(R.id.btnProduitLaitier).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Laitage")
            intentSIA.putExtra("titre", "Ajout d'un produit laitier")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            intentSIA.putExtra("recipe",isRecipe)
            if(isRecipe){
                startActivityForResult(intentSIA,7)
            }else{
                startActivity(intentSIA)
            }        }

        findViewById<LinearLayout>(R.id.btnPatisserie).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Patisserie")
            intentSIA.putExtra("titre", "Ajout d'une pâtisserie")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            intentSIA.putExtra("recipe",isRecipe)
            if(isRecipe){
                startActivityForResult(intentSIA,7)
            }else{
                startActivity(intentSIA)
            }        }

        findViewById<LinearLayout>(R.id.btnSauce).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Sauce")
            intentSIA.putExtra("titre", "Ajout d'une sauce")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            intentSIA.putExtra("recipe",isRecipe)
            if(isRecipe){
                startActivityForResult(intentSIA,7)
            }else{
                startActivity(intentSIA)
            }        }

        findViewById<LinearLayout>(R.id.btnViande).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Viande")
            intentSIA.putExtra("titre", "Ajout d'une viande")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            intentSIA.putExtra("recipe",isRecipe)
            if(isRecipe){
                startActivityForResult(intentSIA,7)
            }else{
                startActivity(intentSIA)
            }        }

        findViewById<LinearLayout>(R.id.btnAutre).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Autre")
            intentSIA.putExtra("titre", "Ajout d'un autre aliment")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            intentSIA.putExtra("recipe",isRecipe)
            if(isRecipe){
                startActivityForResult(intentSIA,7)
            }else{
                startActivity(intentSIA)
            }
        }

        findViewById<Button>(R.id.buttonAnnulerCategorie).setOnClickListener{
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 7) {
            if (resultCode == Activity.RESULT_OK) {
                val previousActivity = Intent(applicationContext,CreateRecipeActivity::class.java)
                previousActivity.putExtra("item",data?.getSerializableExtra("item"))
                setResult(Activity.RESULT_OK,previousActivity)
                finish()
            }
        }
    }
}