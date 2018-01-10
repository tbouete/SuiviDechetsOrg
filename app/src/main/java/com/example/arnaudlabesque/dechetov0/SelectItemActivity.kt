package com.example.arnaudlabesque.dechetov0

import android.app.Activity
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
import elements.ElementFactory
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

        val isRecipe = intent.getBooleanExtra("recipe", false)

        if (intent.getStringExtra("categorie") == "Legume") {
            createElements(R.array.legumes, R.drawable.rounded_square_legume, isRecipe)
        } else if (intent.getStringExtra("categorie") == "Fruit") {
            createElements(R.array.fruits, R.drawable.rounded_square_fruit, isRecipe)
        } else if (intent.getStringExtra("categorie") == "Feculent") {
            createElements(R.array.feculents, R.drawable.rounded_square_feculent, isRecipe)
        } else if (intent.getStringExtra("categorie") == "Laitage") {
            createElements(R.array.laitages, R.drawable.rounded_square_laitage, isRecipe)
        } else if (intent.getStringExtra("categorie") == "Patisserie") {
            createElements(R.array.patisseries, R.drawable.rounded_square_patisserie, isRecipe)
        } else if (intent.getStringExtra("categorie") == "Sauce") {
            createElements(R.array.sauces, R.drawable.rounded_square_sauce, isRecipe)
        } else if (intent.getStringExtra("categorie") == "Viande") {
            createElements(R.array.viandes, R.drawable.rounded_square_viande, isRecipe)
        } else if (intent.getStringExtra("categorie") == "Autre") {
            createElements(R.array.autres, R.drawable.rounded_square_autre, isRecipe)
        }


    }

    private fun createElements(idArray: Int, idBg: Int, isRecipe: Boolean) {
        if(idArray==-1){finish()}
        val myarray = resources.getStringArray(idArray)
        var id = 0
        var nbLeg = 0
        var currentLine = LinearLayout(this)
        currentLine.gravity = Gravity.CENTER
        findViewById<LinearLayout>(R.id.globalLayout).addView(currentLine)

        for (element in myarray) {
            //Log.d("test",element)
            var linearLayout = LinearLayout(this)
            linearLayout.background = getDrawable(idBg)
            val v = Math.round(100 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
            linearLayout.layoutParams = ViewGroup.LayoutParams(v, v)
            linearLayout.gravity = Gravity.CENTER
            var tv = TextView(this)
            tv.id = id++
            tv.text = element
            tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            tv.gravity = Gravity.CENTER
            tv.setTextColor(Color.BLACK)
            linearLayout.addView(tv)
            if (nbLeg % 5 == 0) {
                var myspace = Space(this)
                myspace.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
                currentLine.addView(myspace, 0)
                currentLine = LinearLayout(this)
                findViewById<LinearLayout>(R.id.globalLayout).addView(currentLine)
                currentLine.gravity = Gravity.CENTER
            }

            linearLayout.setOnClickListener {
                if(idArray==R.array.fruits || idArray==R.array.legumes){
                    findViewById<LinearLayout>(R.id.globalLayout).removeAllViews()
                    val newName = element.replace(" ","")
                    //Log.d("test",newName)resources.getIdentifier(newName,"id",packageName)
                    createElements(getIdArray(newName), idBg, isRecipe)
                }else{
                     var inflater = this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                     var popUpView = inflater.inflate(R.layout.layout_pop_up_bio, null)

                     var popup = PopupWindow(popUpView, 1000, ViewGroup.LayoutParams.WRAP_CONTENT)
                     popup.showAtLocation(findViewById<LinearLayout>(R.id.globalLayout), Gravity.CENTER, 0, 0)

                     var btnBio = popUpView.findViewById<Button>(R.id.buttonValidateBio)
                     btnBio.setOnClickListener {
                         var myfactory = ElementFactory()
                         var cbBio = popUpView.findViewById<CheckBox>(R.id.checkBoxBio)
                         var cbNonBio = popUpView.findViewById<CheckBox>(R.id.checkBoxNonBio)
                         var isBio = false
                         if (cbBio.isChecked && cbNonBio.isChecked) {
                             var tvErrorBio = popUpView.findViewById<TextView>(R.id.textErrorBio)
                             tvErrorBio.text = "Attention les cases aliment biologique et non biologique sont cochées !"
                         } else {
                             if (cbBio.isChecked) {
                                 isBio = true
                             }
                             var aliment = myfactory.getCustomElement(element, 1.0, true, isBio, popUpView.findViewById<CheckBox>(R.id.checkBoxPotager).isChecked)

                             if (isRecipe) {

                                 val previousIntent = Intent(this, FoodChoiceActivity::class.java)
                                 previousIntent.putExtra("item", aliment)
                                 previousIntent.putExtra("idColorBG", idBg)
                                 setResult(Activity.RESULT_OK,previousIntent)
                                 popup.dismiss()
                                 finish()

                             } else {

                                 inflater.inflate(R.layout.activity_treat_item, null)
                                 val intent = Intent(this, TreatItemActivity::class.java)
                                 intent.putExtra("item", aliment)
                                 intent.putExtra("idColorBG", idBg)
                                 popup.dismiss()
                                 startActivity(intent)

                             }
                         }

                     }

                }


            }

            currentLine.addView(linearLayout)
            var space = Space(this)
            space.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
            currentLine.addView(space)
            nbLeg++
        }
        var myfinalspace = Space(this)
        myfinalspace.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
        currentLine.addView(myfinalspace, 0)
    }

    private fun getIdArray(name:String):Int=
        when (name) {
            "LégumesTiges" -> R.array.LégumesTiges
            "LégumesRacines" -> R.array.LégumesRacines
            "LégumesGraines" -> R.array.LégumesGraines
            "LégumesFruits" -> R.array.LégumesFruits
            "LégumesFleurs" -> R.array.LégumesFleurs
            "LégumesFeuilles" -> R.array.LégumesFeuilles
            "LégumesBulbes" -> R.array.LégumesBulbes
            "Fruitsàpépins" -> R.array.Fruitsàpépins
            "Fruitssecs" -> R.array.Fruitssecs
            "Fruitsrouges" -> R.array.Fruitsrouges
            "Fruitsexotiques" -> R.array.Fruitsexotiques
            "Fruitsànoyau" -> R.array.Fruitsànoyau
            "Agrumes" -> R.array.Agrumes
            else -> -1
        }

}

