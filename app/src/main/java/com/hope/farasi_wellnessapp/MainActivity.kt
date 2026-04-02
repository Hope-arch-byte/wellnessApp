package com.hope.farasi_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //override is used to modify the parents x-tics
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) //this line is used to link activity_main.xml to the main activity
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //finding the id's from the layout
        //create a variable to store the variables
        val recipe=findViewById<Button>(R.id.recipes)

        //calling the setOnclick listener
        recipe.setOnClickListener {
            //this where the intent is written
            val recipeIntent= Intent(applicationContext, HealthyRecipes::class.java)
            startActivity(recipeIntent) //without this line one's app cannot run
        }
        //nutrition intent
        val nutrition=findViewById<Button>(R.id.nutrition)
        nutrition.setOnClickListener {
            val nutritionIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(nutritionIntent)
        }
        //meditation intent
        val meditation=findViewById<Button>(R.id.meditation)
        meditation.setOnClickListener {
            val meditationIntent= Intent(applicationContext, meditation::class.java)
            startActivity(meditationIntent)
        }
    }
}

