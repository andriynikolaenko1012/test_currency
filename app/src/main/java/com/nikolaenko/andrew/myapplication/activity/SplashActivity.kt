package com.nikolaenko.andrew.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nikolaenko.andrew.myapplication.R
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.os.Handler
import android.support.v4.os.HandlerCompat.postDelayed



class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }, 3000)

    }
}