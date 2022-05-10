package com.malik.eratani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.malik.eratani.animation.AnimationHeartActivity
import com.malik.eratani.apicalling.view.ApiCallingActivity
import com.malik.eratani.databinding.ActivityMainBinding
import com.malik.eratani.searchword.SearchStringActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearching goTo SearchStringActivity::class.java
        binding.btnAnimation goTo AnimationHeartActivity::class.java
        binding.btnApiCalling goTo ApiCallingActivity::class.java
    }

    private fun startActivity(cls: Class<*>){
        startActivity(Intent(this, cls))
    }

    private infix fun View.goTo(cls: Class<*>) {
        setOnClickListener { startActivity(cls) }
    }
}