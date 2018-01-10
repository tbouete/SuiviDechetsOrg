package com.example.arnaudlabesque.dechetov0

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.graphics.drawable.Animatable
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import elements.MealType
import elements.StockElementMeal
import elements.StockMeals
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.ObjectInputStream
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*


class SelectMealActivity : AppCompatActivity() {
    val date = Date()
    var sharedPref: SharedPreferences? = null

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Reprise de l'activité", Toast.LENGTH_SHORT)
        val lPetitDej: LinearLayout = findViewById<View>(R.id.lPetitDej) as LinearLayout
        val lEncas: LinearLayout = findViewById<View>(R.id.lEncas) as LinearLayout
        val lDej: LinearLayout = findViewById<View>(R.id.lDej) as LinearLayout
        val lGouter: LinearLayout = findViewById<View>(R.id.lGouter) as LinearLayout
        val lDiner: LinearLayout = findViewById<View>(R.id.lDiner) as LinearLayout

        var nbClocks = 0

        if (!sharedPref!!.getBoolean("petitDej", false)) {
            lPetitDej.visibility = LinearLayout.GONE
        } else {
            lPetitDej.visibility = LinearLayout.VISIBLE
            nbClocks++
        }
        if (!sharedPref!!.getBoolean("encas", false)) {
            lEncas.visibility = LinearLayout.GONE
        } else {
            lEncas.visibility = LinearLayout.VISIBLE
            nbClocks++
        }
        if (!sharedPref!!.getBoolean("dej", false)) {
            lDej.visibility = LinearLayout.GONE
        } else {
            lDej.visibility = LinearLayout.VISIBLE
            nbClocks++
        }
        if (!sharedPref!!.getBoolean("gouter", false)) {
            lGouter.visibility = LinearLayout.GONE
        } else {
            lGouter.visibility = LinearLayout.VISIBLE
            nbClocks++
        }
        if (!sharedPref!!.getBoolean("diner", false)) {
            lDiner.visibility = LinearLayout.GONE
        } else {
            lDiner.visibility = LinearLayout.VISIBLE
            nbClocks++
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPref = applicationContext.getSharedPreferences("com.example.arnaudlabesque.dechetov0.prefs", Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_meal)

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Selection du repas - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val itemSettings = findViewById<View>(R.id.itemSettings)
        itemSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }


        val imageViewPetitDej: ImageView = findViewById<View>(R.id.btnPetitDej) as ImageView
        val imageViewEncas: ImageView = findViewById<View>(R.id.btnEncas) as ImageView
        val imageViewDej: ImageView = findViewById<View>(R.id.btnDej) as ImageView
        val imageViewGouter: ImageView = findViewById<View>(R.id.btnGouter) as ImageView
        val imageViewDiner: ImageView = findViewById<View>(R.id.btnDiner) as ImageView
        val imageViewAutre: ImageView = findViewById<View>(R.id.btnAutre) as ImageView

        val dPetitDej = imageViewPetitDej.drawable
        if (dPetitDej is Animatable) {
            (dPetitDej as Animatable).start()
        }

        val dEncas = imageViewEncas.drawable
        if (dEncas is Animatable) {
            (dEncas as Animatable).start()
        }

        val dDej = imageViewDej.drawable
        if (dDej is Animatable) {
            (dDej as Animatable).start()
        }

        val dGouter = imageViewGouter.drawable
        if (dGouter is Animatable) {
            (dGouter as Animatable).start()
        }

        val dDiner = imageViewDiner.drawable
        if (dDiner is Animatable) {
            (dDiner as Animatable).start()
        }

        val dAutre = imageViewAutre.drawable
        if (dAutre is Animatable) {
            (dAutre as Animatable).start()
        }

    }

    var myStockMeal = StockMeals()


    fun actionPetitDej(v: View) {
        if (v.id == R.id.btnPetitDej) {
            var myStockElementMeal = StockElementMeal(MealType.breakfast.toString(),Date())
            myStockElementMeal.addObserver(myStockMeal)
            myStockMeal.listSEM.add(myStockElementMeal)
            val intent = Intent(this, MealCompositionActivity::class.java)
            intent.putExtra("meal", "petit-déjeuner")
            intent.putExtra("stockElementMeal",myStockElementMeal)
            startActivity(intent)
        }
    }

    fun actionEncas(v: View) {
        if (v.id == R.id.btnEncas) {
            //Toast.makeText(this, "Je suis un encas", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MealCompositionActivity::class.java)
            intent.putExtra("meal", "en-cas")
            startActivity(intent)
        }
    }

    fun actionDej(v: View) {
        if (v.id == R.id.btnDej) {

            //val sdf = SimpleDateFormat("dd-MMMM-yy",Locale.FRENCH)
            //Toast.makeText(this, "Je suis un déjeuner", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MealCompositionActivity::class.java)
            intent.putExtra("meal", "déjeuner")
            startActivity(intent)
        }
    }

    fun actionGouter(v: View) {
        if (v.id == R.id.btnGouter) {
            //Toast.makeText(this, "Je suis un goûter", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MealCompositionActivity::class.java)
            intent.putExtra("meal", "goûter")
            startActivity(intent)
        }
    }

    fun actionDiner(v: View) {
        if (v.id == R.id.btnDiner) {
            //Toast.makeText(this, "Je suis un diner", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MealCompositionActivity::class.java)
            intent.putExtra("meal", "dîner")
            startActivity(intent)
        }
    }

    fun actionAutre(v: View) {
        if (v.id == R.id.btnAutre) {
            //Toast.makeText(this, "Je suis un autre repas", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MealCompositionActivity::class.java)
            intent.putExtra("meal", "autre")
            startActivity(intent)
        }
    }


}
