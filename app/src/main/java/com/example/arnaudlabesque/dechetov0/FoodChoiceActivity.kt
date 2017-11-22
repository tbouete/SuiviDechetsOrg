package com.example.arnaudlabesque.dechetov0

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.LinearLayout
import java.text.SimpleDateFormat
import java.util.*

/**
* Created by arnaud.labesque on 17/11/2017.
*/
class FoodChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_choice)


        val selectedMeal = intent.getStringExtra("meal")

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Ajout d'un aliment pour le " + selectedMeal + " - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
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
            startActivity(intentSIA)
        }

        findViewById<LinearLayout>(R.id.btnLegume).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Legume")
            intentSIA.putExtra("titre", "Ajout d'un légume")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            startActivity(intentSIA)
        }

        findViewById<LinearLayout>(R.id.btnFeculent).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Feculent")
            intentSIA.putExtra("titre", "Ajout d'un féculent")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            startActivity(intentSIA)
        }

        findViewById<LinearLayout>(R.id.btnProduitLaitier).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Laitage")
            intentSIA.putExtra("titre", "Ajout d'un produit laitier")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            startActivity(intentSIA)
        }

        findViewById<LinearLayout>(R.id.btnPatisserie).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Patisserie")
            intentSIA.putExtra("titre", "Ajout d'une pâtisserie")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            startActivity(intentSIA)
        }

        findViewById<LinearLayout>(R.id.btnSauce).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Sauce")
            intentSIA.putExtra("titre", "Ajout d'une sauce")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            startActivity(intentSIA)
        }

        findViewById<LinearLayout>(R.id.btnViande).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Viande")
            intentSIA.putExtra("titre", "Ajout d'une viande")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            startActivity(intentSIA)
        }

        findViewById<LinearLayout>(R.id.btnAutre).setOnClickListener{
            val intentSIA = Intent(this, SelectItemActivity::class.java)
            intentSIA.putExtra("categorie", "Autre")
            intentSIA.putExtra("titre", "Ajout d'un autre aliment")
            intentSIA.putExtra("meal",intent.getStringExtra("meal"))
            startActivity(intentSIA)
        }
    }



        /*fun ajouterFruit(v: View) {
            if (v.id == R.id.btnLegume) {
                val intent = Intent(this, SelectItemActivity::class.java)
                intent.putExtra("categorie", "Fruit")
                intent.putExtra("titre", "Ajout d'un fruit")
                intent.putExtra("meal",intent.getStringExtra("meal"))
                startActivity(intent)
            }
        }

        fun ajouterFeculent(v: View) {
            if (v.id == R.id.btnFeculent) {
                val intent = Intent(this, SelectItemActivity::class.java)
                intent.putExtra("categorie", "Feculent")
                intent.putExtra("titre", "Ajout d'un féculent")
                intent.putExtra("meal",intent.getStringExtra("meal"))
                startActivity(intent)
            }
        }

        fun ajouterProduitLaitier(v: View) {
            if (v.id == R.id.btnProduitLaitier) {
                val intent = Intent(this, SelectItemActivity::class.java)
                intent.putExtra("categorie", "Produit Laitier")
                intent.putExtra("titre", "Ajout d'un produit laitier")
                intent.putExtra("meal",intent.getStringExtra("meal"))
                startActivity(intent)
            }
        }

        fun ajouterViande(v: View) {
            if (v.id == R.id.btnViande) {
                val intent = Intent(this, SelectItemActivity::class.java)
                intent.putExtra("categorie", "Viande")
                intent.putExtra("titre", "Ajout d'une viande")
                intent.putExtra("meal",intent.getStringExtra("meal"))
                startActivity(intent)
            }
        }

        fun ajouterPatisserie(v: View) {
            if (v.id == R.id.btnPatisserie) {
                val intent = Intent(this, SelectItemActivity::class.java)
                intent.putExtra("categorie", "Patisserie")
                intent.putExtra("titre", "Ajout d'une pâtisserie")
                intent.putExtra("meal",intent.getStringExtra("meal"))
                startActivity(intent)
            }
        }

        fun ajouterSauce(v: View) {
            if (v.id == R.id.btnSauce) {
                val intent = Intent(this, SelectItemActivity::class.java)
                intent.putExtra("categorie", "Sauce")
                intent.putExtra("titre", "Ajout d'une sauce")
                intent.putExtra("meal",intent.getStringExtra("meal"))
                startActivity(intent)
            }
        }

        fun ajouterAutre(v: View) {
            if (v.id == R.id.btnAutre) {
                val intent = Intent(this, SelectItemActivity::class.java)
                intent.putExtra("categorie", "Autre")
                intent.putExtra("titre", "Ajout d'un autre produit")
                intent.putExtra("meal",intent.getStringExtra("meal"))
                startActivity(intent)
            }
        }*/


}