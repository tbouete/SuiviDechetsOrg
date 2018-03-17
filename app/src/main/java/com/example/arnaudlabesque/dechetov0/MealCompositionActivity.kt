package com.example.arnaudlabesque.dechetov0

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import elements.StockMeals
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by arnaud.labesque on 16/11/2017.
 */


class MealCompositionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_composition)

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Selection du " + intent.getStringExtra("meal") + " - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN





        findViewById<View>(R.id.itemSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.lAjoutAliment).setOnClickListener {
            val myIntent = Intent(this, FoodChoiceActivity::class.java)
            myIntent.putExtra("meal",intent.getStringExtra("meal"))
            myIntent.putExtra("stockMeal",intent.getSerializableExtra("stockMeal"))
            startActivity(myIntent)
        }

        findViewById<View>(R.id.lCreateRecipe).setOnClickListener {
            val myIntent = Intent(this, CreateRecipeActivity::class.java)
            myIntent.putExtra("stockMeal",intent.getSerializableExtra("stockMeal"))
            startActivity(myIntent)
        }


        findViewById<View>(R.id.lShowWaste).setOnClickListener {
            val myIntent = Intent(this, ShowWasteActivity::class.java)
            myIntent.putExtra("stockMeal",intent.getSerializableExtra("stockMeal"))
            startActivity(myIntent)
        }

        findViewById<View>(R.id.lCancelML).setOnClickListener {
            finish()
        }

    }
    override fun onResume() {
        super.onResume()
        var truc = intent.getSerializableExtra("eatenMeal")
        if(truc != null) {
            truc as StockMeals
            Log.d("testarnaudtumecroispas", truc.listSEM[truc.listSEM.lastIndex].listElementEaten.toString())

            findViewById<LinearLayout>(R.id.lAjoutAliment).setOnClickListener {
                val myIntent = Intent(this, FoodChoiceActivity::class.java)
                myIntent.putExtra("meal",intent.getStringExtra("meal"))
                myIntent.putExtra("stockMeal",intent.getSerializableExtra("stockMeal"))
                startActivity(myIntent)
            }

            findViewById<View>(R.id.lCreateRecipe).setOnClickListener {
                val myIntent = Intent(this, CreateRecipeActivity::class.java)
                myIntent.putExtra("stockMeal",intent.getSerializableExtra("stockMeal"))
                startActivity(myIntent)
            }


            findViewById<View>(R.id.lShowWaste).setOnClickListener {
                val myIntent = Intent(this, ShowWasteActivity::class.java)
                myIntent.putExtra("stockMeal",intent.getSerializableExtra("stockMeal"))
                startActivity(myIntent)
            }



        }
        else
        {
            Log.d("test","null")
        }

    }
}