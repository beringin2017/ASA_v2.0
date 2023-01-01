package com.imk.asa20

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR
import androidx.appcompat.widget.Toolbar
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private val handler = Handler()
    private val updateDateRunnable = object : Runnable {

        override fun run() {
            val calendar = Calendar.getInstance()
            val dateFormat = SimpleDateFormat("dd.MM.yyyy")
            val dayFormat = SimpleDateFormat("EEEE")
            val timeFormat = SimpleDateFormat("HH:mm:ss")
            val timeTextView = findViewById<TextView>(R.id.systemTime)
            val dateTextView = findViewById<TextView>(R.id.systemDate)
            val dayTextView = findViewById<TextView>(R.id.systemDay)

            dateTextView.text =" " + dateFormat.format(calendar.time)
            dayTextView.text =" " + dayFormat.format(calendar.time)
            timeTextView.text =" " + timeFormat.format(calendar.time)
            handler.postDelayed(this, 1000)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("ASA 2.0")
        toolbar.setSubtitleTextColor(resources.getColor(android.R.color.white))
        toolbar.setTitleTextColor(resources.getColor(android.R.color.white))

        val krsButton = findViewById<LinearLayout>(R.id.krsLayout)
        val elearnButton = findViewById<LinearLayout>(R.id.eLearnLayout)
        val asButton = findViewById<LinearLayout>(R.id.asLayout)

        handler.post(updateDateRunnable)


        krsButton.setOnClickListener(){
            val intent = Intent(this, fragContainer::class.java)
            intent.putExtra("judul", "KRS")
            intent.putExtra("id", 1)
            startActivity(intent)
        }

        elearnButton.setOnClickListener(){
            val intent = Intent(this, fragContainer::class.java)
            intent.putExtra("judul", "e-Learning")
            intent.putExtra("id", 2)
            startActivity(intent)
        }

        asButton.setOnClickListener(){
            val intent = Intent(this, fragContainer::class.java)
            intent.putExtra("judul", "Ajukan Surat")
            intent.putExtra("id", 3)
            startActivity(intent)
        }

    }
}