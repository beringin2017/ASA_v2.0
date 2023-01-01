package com.imk.asa20

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class fragContainer : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_container)



        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        val intent = intent
        val judul = intent.getStringExtra("judul")
        val id = intent.getIntExtra("id", 0)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(judul)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        toolbar.setSubtitleTextColor(resources.getColor(android.R.color.white))
        toolbar.setTitleTextColor(resources.getColor(android.R.color.white))
        toolbar.setNavigationOnClickListener{
            finish()
        }

        fun makeCurrentFragment(fragment: Fragment){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout,fragment)
            transaction.commit()
        }

        val krsFrag = kartuRencanaStudi()
        val elFrag = Elearning()
        val ajukansurat = Ajukansurat()
        if (id == 1){
            makeCurrentFragment(krsFrag)
        }
        else if(id == 2){
            makeCurrentFragment(elFrag)
        }
        else if (id == 3){
            makeCurrentFragment(ajukansurat)
        }



    }
}