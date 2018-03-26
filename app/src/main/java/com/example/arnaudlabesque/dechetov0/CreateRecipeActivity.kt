package com.example.arnaudlabesque.dechetov0

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import elements.ComposedElement
import elements.Element
import kotlinx.android.synthetic.main.activity_create_recipe.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by arnaud.labesque on 09/01/2018.
 */

class CreateRecipeActivity : AppCompatActivity() {

    var id = 0
    var aliments = ArrayList<Element>()

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
            val etRecipeName = findViewById<EditText>(R.id.etRecipeName)
            val recipeName =  etRecipeName.text.toString()
            if (recipeName == "") {
                intentRecipe.putExtra("recipeName", "Votre plat")
            } else {
                intentRecipe.putExtra("recipeName", recipeName)
            }
            intentRecipe.putExtra("recipe", true)
            startActivityForResult(intentRecipe, 7)
        }

        findViewById<View>(R.id.lCancel).setOnClickListener{
            finish()
        }

        findViewById<Button>(R.id.buttonValidateRecipe).setOnClickListener {
            var etRecipe = findViewById<EditText>(R.id.etRecipeName) as EditText
            if (etRecipe.text.toString() == "" ){
                var tvErrorRecipe = findViewById<TextView>(R.id.textErrorRecipe)
                tvErrorRecipe.text = "Veuillez entrer un nom pour votre plat !"
            }else{
                val intentTreatRecipe = Intent(this, TreatItemActivity::class.java)

                intentTreatRecipe.putExtra("isRecipe", true)
                val etRecipeName = findViewById<EditText>(R.id.etRecipeName)
                val recipeName =  etRecipeName.text.toString()
                recette.basicName = recipeName
                intentTreatRecipe.putExtra("recipe", recette)
                intentTreatRecipe.putExtra("items",aliments)
                intentTreatRecipe.putExtra("stockMeal", intent.getSerializableExtra("stockMeal"))

                finish()
                startActivity(intentTreatRecipe)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data : Intent? ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 7) {
            if (resultCode == Activity.RESULT_OK) {
                var currentLine = LinearLayout(this)
                val lAlimentRecipe = findViewById<LinearLayout>(R.id.lAlimentRecipe)
                val aliment = data?.getSerializableExtra("item") as Element

                val previousAliments = data?.getSerializableExtra("items") as ArrayList<Element>
                for (previousAliment in previousAliments){
                    aliments.add(previousAliment)
                }

                var linearLayout = LinearLayout(this)
                linearLayout.background = getDrawable(R.drawable.rounded_square)
                val v = Math.round(90 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
                linearLayout.layoutParams = ViewGroup.LayoutParams(v, v)
                linearLayout.orientation = LinearLayout.VERTICAL
                linearLayout.gravity = Gravity.CENTER

                var imageView = ImageView(this)
                imageView.setImageResource(getIdPicture(aliment.basicName))
                imageView.layoutParams = TableRow.LayoutParams(60, 60,0.5f)
                linearLayout.addView(imageView)

                var tv = TextView(this)
                tv.id = id++
                tv.text = aliment.basicName
                tv.layoutParams = TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f)
                tv.gravity = Gravity.CENTER
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
                tv.setTextColor(Color.BLACK)
                linearLayout.addView(tv)

                currentLine.addView(linearLayout)
                var space = Space(this)
                space.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
                currentLine.addView(space)

                lAlimentRecipe.addView(currentLine)

                recette.composition.add(aliment)
            }
        }
    }

    private fun getIdPicture(element: String?): Int =
            when (element) {
                "Légumes Bulbes" -> R.drawable.legumebulbe
                "Légumes Tiges" -> R.drawable.legumetige
                "Légumes Racines" -> R.drawable.legumesracine
                "Légumes Graines" -> R.drawable.legumegraine
                "Légumes Fruitiers" -> R.drawable.legumefruit
                "Légumes Fleurs" -> R.drawable.legumefleur
                "Légumes Feuilles" -> R.drawable.legumefeuille
                "Fruits à pépins" -> R.drawable.fruitpepins
                "Fruits secs" -> R.drawable.fruitsec
                "Fruits rouges" -> R.drawable.fruitrouge
                "Fruits exotiques" -> R.drawable.fruitexotique
                "Fruits à noyau" -> R.drawable.fruitnoyau
                "Agrumes" -> R.drawable.agrume
                "Asperge" -> R.drawable.asperge
                "Rhubarbe" -> R.drawable.rhubarbe
                "Betterave" -> R.drawable.betterave
                "Carotte" -> R.drawable.carotte
                "Champignon" -> R.drawable.champignon
                "Céleri rave" -> R.drawable.celerirave
                "Navet" -> R.drawable.navet
                "Panais" -> R.drawable.panais
                "Patate douce" -> R.drawable.patatedouce
                "Pomme de terre" -> R.drawable.patate
                "Radis rouge" -> R.drawable.radisrouge
                "Radis noir" -> R.drawable.radisnoir
                "Salsifis" -> R.drawable.salsifis
                "Haricot" -> R.drawable.haricot
                "Petit pois" -> R.drawable.petitspois
                "Pois à écosser" -> R.drawable.poisaecosser
                "Aubergine" -> R.drawable.aubergine
                "Avocat" -> R.drawable.avocat
                "Châtaigne" -> R.drawable.chataigne
                "Citrouille,Courge,Potiron" -> R.drawable.courges
                "Concombre" -> R.drawable.concombre
                "Cornichon" -> R.drawable.cornichon
                "Courgette" -> R.drawable.courgette
                "Poivron" -> R.drawable.poivrons
                "Tomate" -> R.drawable.tomate
                "Artichaut" -> R.drawable.artichaux
                "Brocoli" -> R.drawable.brocoli
                "Chou-fleur" -> R.drawable.choufleur
                "Blette" -> R.drawable.blette
                "Céleri branche" -> R.drawable.celeribranche
                "Chou vert" -> R.drawable.chouxdebruxellechouvert
                "Chou de Bruxelles" -> R.drawable.chouxdebruxellechouvert
                "Endive" -> R.drawable.endives
                "Epinard" -> R.drawable.epinard
                "Salade entière" -> R.drawable.salade
                "Salade en sachet" -> R.drawable.saladesachet
                "Poireau" -> R.drawable.poireau
                "Ail" -> R.drawable.ail
                "Fenouil" -> R.drawable.fenouil
                "Oignon" -> R.drawable.oignon
                "Echalote" -> R.drawable.echalotte
                "Melon" -> R.drawable.melon
                "Pastèque" -> R.drawable.pasteque
                "Coing" -> R.drawable.coing
                "Figue" -> R.drawable.figue
                "Kaki" -> R.drawable.kaki
                "Kiwi" -> R.drawable.kiwi
                "Poire" -> R.drawable.poire
                "Pomme" -> R.drawable.pomme
                "Raisin" -> R.drawable.raisin
                "Noix" -> R.drawable.noix
                "Noisette" -> R.drawable.noisette
                "Amande" -> R.drawable.amande
                "Petits fruits" -> R.drawable.petitsfruitsrouges
                "Fraise" -> R.drawable.fraise
                "Noix de coco" -> R.drawable.noixdecoco
                "Ananas" -> R.drawable.ananas
                "Banane" -> R.drawable.banane
                "Fruit de la passion" -> R.drawable.fruitdelapassion
                "Grenade" -> R.drawable.grenade
                "Litchi" -> R.drawable.litchi
                "Mangue" -> R.drawable.mangue
                "Papaye" -> R.drawable.papaye
                "Abricot" -> R.drawable.abricot
                "Cerise" -> R.drawable.cerise
                "Datte" -> R.drawable.dattes
                "Pêche" -> R.drawable.peche
                "Nectarine" -> R.drawable.nectarine
                "Brugnon" -> R.drawable.brugnon
                "Prune" -> R.drawable.prune
                "Citron" -> R.drawable.citron
                "Clémentine" -> R.drawable.clementine
                "Mandarine" -> R.drawable.mandarine
                "Orange" -> R.drawable.orange
                "Pamplemousse" -> R.drawable.pamplemousse
                "Boeuf" -> R.drawable.boeuf
                "Volaille" -> R.drawable.poulet
                "Porc" -> R.drawable.porc
                "Mouton" -> R.drawable.agneau
                "Poisson" -> R.drawable.poisson
                "Œuf" -> R.drawable.oeuf
                "Lait" -> R.drawable.lait
                "Crème" -> R.drawable.creme_fraiche
                "Yaourt" -> R.drawable.yaourt
                "Fromage" -> R.drawable.fromage
                "Pâte" -> R.drawable.pates
                "Riz" -> R.drawable.riz
                "Semoule" -> R.drawable.semoule
                "Lentilles" -> R.drawable.lentilles
                "Pain" -> R.drawable.pain
                "Gâteau" -> R.drawable.gateau
                "Ketchup" -> R.drawable.ketchup
                "Mayonnaise" -> R.drawable.mayonnaise
                "Moutarde" -> R.drawable.moutarde
                "Vinaigrette" -> R.drawable.vinaigrette
                "Sauce tomate" -> R.drawable.sauce_tomate
                "Pizza" -> R.drawable.pizza
                "Plat surgelé" -> R.drawable.plats_surgeles
                "Plat préparé" -> R.drawable.plats_prepares
                "Thé" -> R.drawable.the
                "Café" -> R.drawable.cafe
                else -> -1
            }
}