package com.hope.farasi_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds

import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {

    // declare a variable to store an interstitial ad
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //override is used to modify the parents x-tics
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) //this line is used to link activity_main.xml to the main activity

        //implementation of the banner ad

        MobileAds.initialize(this) //used to start the google admob sdk/ prepares your app to load apps
        val adView = findViewById<AdView>(R.id.adView) //gotten from the layout and it connects your kotlin code to the adview in xml
        val adRequest = AdRequest.Builder().build() //used to request ads from admob
        adView.loadAd(adRequest) //used to load the ads returned by admob

        //calling the fxn to load the ad
        loadInterstitialAd()


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
            showInterstitialAd()
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
        //hydration intent
        val hydration=findViewById<Button>(R.id.hydration)
        hydration.setOnClickListener {
            val hydrationIntent= Intent(applicationContext, HydrationAlert::class.java)
            startActivity(hydrationIntent)
        }
        //exercise intent
        val exercise=findViewById<Button>(R.id.exercise)
        exercise.setOnClickListener {
            val exerciseIntent= Intent(applicationContext, StartExercise::class.java)
            startActivity(exerciseIntent)
        }
        //motivation intent
        val motivation=findViewById<Button>(R.id.motivation)
        motivation.setOnClickListener {
            val motivationIntent= Intent(applicationContext, DailyMotivation::class.java)
            startActivity(motivationIntent)
        }
        //goals intent
        val goal=findViewById<Button>(R.id.goals)
        goal.setOnClickListener {
            val goalIntent= Intent(applicationContext, WeeklyGoals::class.java)
            startActivity(goalIntent)
        }
        //progress intent
        val progress=findViewById<Button>(R.id.progress)
        progress.setOnClickListener {
            val progressIntent= Intent(applicationContext, CheckProgress::class.java)
            startActivity(progressIntent)
        }
    }

    // a function to load our ad from the server

    fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712", // Test ID
            adRequest,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    mInterstitialAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                }
            }
        )
    }
    //Show Interstitial ad
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }
}

