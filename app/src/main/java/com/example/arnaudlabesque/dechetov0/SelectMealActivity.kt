package com.example.arnaudlabesque.dechetov0

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.View
import android.graphics.drawable.Animatable
import android.widget.ImageView
import java.text.SimpleDateFormat
import java.util.*


class SelectMealActivity : AppCompatActivity() {
    val date = Date()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_meal)

        val imageViewPetitDej: ImageView = findViewById<View>(R.id.btnPetitDej) as ImageView
        val imageViewDej: ImageView = findViewById<View>(R.id.btnDej) as ImageView
        val imageViewGouter: ImageView = findViewById<View>(R.id.btnGouter) as ImageView
        val imageViewDiner: ImageView = findViewById<View>(R.id.btnDiner) as ImageView
        val imageViewAutre: ImageView = findViewById<View>(R.id.btnAutre) as ImageView

        val dPetitDej = imageViewPetitDej.getDrawable()
        if (dPetitDej is Animatable) {
                (dPetitDej as Animatable).start()
        }

        val dDej = imageViewDej.getDrawable()
        if (dDej is Animatable) {
            (dDej as Animatable).start()
        }

        val dGouter = imageViewGouter.getDrawable()
        if (dGouter is Animatable) {
            (dGouter as Animatable).start()
        }

        val dDiner = imageViewDiner.getDrawable()
        if (dDiner is Animatable) {
            (dDiner as Animatable).start()
        }

        val dAutre = imageViewAutre.getDrawable()
        if (dAutre is Animatable) {
            (dAutre as Animatable).start()
        }

    }

    fun actionPetitDej(v: View){
        if(v.id==R.id.btnPetitDej) {
            Toast.makeText(this, "Je suis un petit-déjeuner", Toast.LENGTH_SHORT).show()
        }
    }

    fun actionDej(v: View){
        if(v.id==R.id.btnDej) {

            val sdf = SimpleDateFormat("dd-MMMM-yy",Locale.FRENCH)
            Toast.makeText(this, "Je suis un déjeuner"+sdf.format(date), Toast.LENGTH_SHORT).show()
        }
    }

    fun actionGouter(v: View){
        if(v.id==R.id.btnGouter) {
            Toast.makeText(this, "Je suis un goûter", Toast.LENGTH_SHORT).show()
        }
    }

    fun actionDiner(v: View){
        if(v.id==R.id.btnDiner) {
            Toast.makeText(this, "Je suis un diner", Toast.LENGTH_SHORT).show()
        }
    }

    fun actionAutre(v: View){
        if(v.id==R.id.btnAutre) {
            Toast.makeText(this, "Je suis un autre repas", Toast.LENGTH_SHORT).show()
        }
    }
}
