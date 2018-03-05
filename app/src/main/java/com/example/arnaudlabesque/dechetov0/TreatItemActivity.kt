package com.example.arnaudlabesque.dechetov0

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.DisplayMetrics
import elements.Element
import elements.ElementFactory
import java.text.SimpleDateFormat
import java.util.*
import android.support.v4.view.ViewCompat.startDragAndDrop
import android.os.Build
import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipDescription.MIMETYPE_TEXT_PLAIN
import android.content.Context
import android.util.Log
import android.view.*
import android.widget.*
import elements.StockElementMeal
import elements.StockMeals
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream


/**
 * Created by arnaud.labesque on 08/01/2018.
 */

class TreatItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treat_item)

        val lTreatableItem = findViewById<View>(R.id.treatableItem) as LinearLayout

        val aliment = intent.getSerializableExtra("item") as Element
        val idBG = intent.getIntExtra("idColorBG", 0)
        createElement(aliment.basicName, idBG)

        val tl = findViewById<Toolbar>(R.id.my_toolbar)
        tl.title = "Traitement de l'aliment " + aliment.basicName + " - " + SimpleDateFormat("dd-MMMM-yy", Locale.FRENCH).format(Date()).replace("-", " ")
        tl.inflateMenu(R.menu.menu_settings)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        findViewById<View>(R.id.itemSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        var stockMeals = StockMeals()

        try {
            val fis = openFileInput("test.srz")
            val ois = ObjectInputStream(fis)
            stockMeals = ois.readObject() as StockMeals
            ois.close()
            fis.close()
            Log.d("first", stockMeals.toString())
        } catch (e: Exception) {
            Log.d("first", "Erreur pendant la deserialisation : " + e)
            System.exit(2)
        }

        findViewById<LinearLayout>(R.id.btnComposte).setOnDragListener  { view, dragEvent ->
            true
            val draggedImageView = dragEvent.localState as View
            val sem = StockElementMeal("repas", Date())
            when (dragEvent.action) {
                DragEvent.ACTION_DROP -> {
                    sem.addToComposted(aliment)
                    stockMeals.listSEM.add(sem)
                    try {
                        val fos = openFileOutput("test.srz", Context.MODE_PRIVATE)
                        val os = ObjectOutputStream(fos)
                        os.writeObject(stockMeals)
                        os.close()
                        fos.close()
                        draggedImageView.visibility = View.INVISIBLE
                    } catch (e: Exception) {
                        Log.d("deuxieme", "Erreur pendant la serialisation : " + e)
                        System.exit(2)
                    }

                }

                else -> true
            }

            true
        }


        findViewById<LinearLayout>(R.id.btnFrigo).setOnDragListener { view, dragEvent ->
            true
            val draggedImageView = dragEvent.localState as View
            val sem = StockElementMeal("repas", Date())
            when (dragEvent.action) {
                DragEvent.ACTION_DROP -> {
                    sem.addToStocked(aliment)
                    try {
                        val fos = openFileOutput("test.srz", Context.MODE_PRIVATE)
                        val os = ObjectOutputStream(fos)
                        os.writeObject(stockMeals)
                        os.close()
                        fos.close()
                        draggedImageView.visibility = View.INVISIBLE
                    } catch (e: Exception) {
                        Log.d("deuxieme", "Erreur pendant la serialisation : " + e)
                        System.exit(2)
                    }
                    stockMeals.listSEM.add(sem)
                }

                else -> false
            }

            true
        }

        findViewById<LinearLayout>(R.id.btnAssiette).setOnDragListener { view, dragEvent ->
            true
            val draggedImageView = dragEvent.localState as View
            val sem = StockElementMeal("repas", Date())
            when (dragEvent.action) {
                DragEvent.ACTION_DROP -> {
                    sem.addToEaten(aliment)
                    try {
                        val fos = openFileOutput("test.srz", Context.MODE_PRIVATE)
                        val os = ObjectOutputStream(fos)
                        os.writeObject(stockMeals)
                        os.close()
                        fos.close()
                        draggedImageView.visibility = View.INVISIBLE
                    } catch (e: Exception) {
                        Log.d("deuxieme", "Erreur pendant la serialisation : " + e)
                        System.exit(2)
                    }
                    stockMeals.listSEM.add(sem)
                }
                else -> false
            }

            true
        }

        findViewById<LinearLayout>(R.id.btnChien).setOnDragListener { view, dragEvent ->
            true
            val draggedImageView = dragEvent.localState as View
            val sem = StockElementMeal("repas", Date())
            when (dragEvent.action) {
                DragEvent.ACTION_DROP -> {
                    sem.addToFed(aliment)
                    try {
                        val fos = openFileOutput("test.srz", Context.MODE_PRIVATE)
                        val os = ObjectOutputStream(fos)
                        os.writeObject(stockMeals)
                        os.close()
                        fos.close()
                        draggedImageView.visibility = View.INVISIBLE
                    } catch (e: Exception) {
                        Log.d("deuxieme", "Erreur pendant la serialisation : " + e)
                        System.exit(2)
                    }
                    stockMeals.listSEM.add(sem)
                }
                else -> false
            }

            true
        }

        findViewById<LinearLayout>(R.id.btnPoubelle).setOnDragListener { view, dragEvent ->
            true
            val draggedImageView = dragEvent.localState as View
            val sem = StockElementMeal("repas", Date())
            when (dragEvent.action) {
                DragEvent.ACTION_DROP -> {
                    sem.addToThrowed(aliment)
                    try {
                        val fos = openFileOutput("test.srz", Context.MODE_PRIVATE)
                        val os = ObjectOutputStream(fos)
                        os.writeObject(stockMeals)
                        os.close()
                        fos.close()
                        draggedImageView.visibility = View.INVISIBLE
                    } catch (e: Exception) {
                        Log.d("deuxieme", "Erreur pendant la serialisation : " + e)
                        System.exit(2)
                    }
                    stockMeals.listSEM.add(sem)
                }
                else -> false
            }

            true
        }

        if (aliment.isGeneratingBone) {
            createElement("Os de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingCore) {
            when (aliment.basicName){
                "Pomme" -> createElement("Trognon de " + aliment.basicName, idBG)
                "Poire" -> createElement("Trognon de " + aliment.basicName, idBG)
                "Ananas" -> createElement("Trognon d' " + aliment.basicName, idBG)
                else ->createElement("Noyau de " + aliment.basicName, idBG)
            }
        }

        if (aliment.isGeneratingCrust) {
            createElement("Croûte de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingFat) {
            createElement("Gras de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingFilter) {
            createElement("Filtre de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingPeel) {
            createElement("Peau de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingMeatSkin) {
            createElement("Peau de " + aliment.basicName, idBG)
        }
        if (aliment.isGeneratingTail) {
            createElement("Queue de " + aliment.basicName, idBG)
        }

    }

    fun createElement(elementName: String, idBg: Int) {
        var id = 0
        var currentLine = LinearLayout(this)
        currentLine.gravity = Gravity.CENTER
        findViewById<LinearLayout>(R.id.treatableItem).addView(currentLine)

        //Log.d("test",element)
        var linearLayout = LinearLayout(this)
        if (idBg == 0) {
            linearLayout.background = getDrawable(R.drawable.rounded_square)
        } else {
            linearLayout.background = getDrawable(idBg)
        }

        val v = Math.round(100 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        linearLayout.layoutParams = ViewGroup.LayoutParams(v, v)
        linearLayout.gravity = Gravity.CENTER
        linearLayout.tag = elementName
        var tv = TextView(this)
        tv.id = id++
        tv.text = elementName
        tv.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        tv.setTextColor(Color.BLACK)
        linearLayout.addView(tv)


        currentLine.addView(linearLayout)
        var space = Space(this)
        space.layoutParams = TableLayout.LayoutParams(0, Math.round(1 * (this.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)), 1f)
        currentLine.addView(space)
        linearLayout.setOnTouchListener(ChoiceTouchListener())
        //linearLayout.setOnLongClickListener(MyOnLongClickListener())
    }
}

internal class ChoiceTouchListener : View.OnTouchListener {
    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        if (motionEvent.action == MotionEvent.ACTION_DOWN) {
            //setup drag
            val data = ClipData.newPlainText("", "")
            val shadowBuilder = View.DragShadowBuilder(view)
            //start dragging the item touched
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                view.startDragAndDrop(data, shadowBuilder, view, 0)
            }else{
                view.startDrag(data, shadowBuilder, view, 0)
            }

            return true
        } else {
            return false
        }

    }
}

internal class MyDragEventListener : View.OnDragListener {
    override fun onDrag(view : View, event : DragEvent) : Boolean{
        var action = event.action
        when(action){
            DragEvent.ACTION_DROP -> {
                Log.d("test","drop")
                val item = event.clipData.getItemAt(0)
                //val dragData = item.text
                Log.d("test",item.text as String)
                view.setBackgroundColor(Color.TRANSPARENT)
                return true
            }

            DragEvent.ACTION_DRAG_STARTED -> {
                Log.d("test","started")
                if(event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    view.setBackgroundColor(Color.BLUE)
                    view.invalidate()
                    return true
                }
                return false
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                Log.d("test","entered")
                view.setBackgroundColor(Color.GREEN)
                view.invalidate()
                return true
            }
            DragEvent.ACTION_DRAG_LOCATION -> return true

            DragEvent.ACTION_DRAG_EXITED -> {
                Log.d("test","exited")
                view.setBackgroundColor(Color.BLUE)
                view.invalidate()
                return true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                Log.d("test","ended")
                view.setBackgroundColor(Color.TRANSPARENT)
                view.invalidate()
                if(event.result) {
                    Log.d("test","drop was handled")
                }else {
                    Log.d("test","drop was not handled")
                }
            }

        }
        return false
        }
    }
