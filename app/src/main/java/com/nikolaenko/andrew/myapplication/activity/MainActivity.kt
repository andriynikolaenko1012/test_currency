package com.nikolaenko.andrew.myapplication.activity

import android.os.Bundle
import android.os.Handler
import android.widget.FrameLayout
import com.github.salomonbrys.kodein.android.KodeinAppCompatActivity
import com.nikolaenko.andrew.myapplication.fragment.FragmentMain
import com.nikolaenko.andrew.myapplication.R
import org.jetbrains.anko.toast

class MainActivity : KodeinAppCompatActivity() {

    internal var doubleBackToExitPressedOnce = false

    var progressView: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        progressView = findViewById(R.id.progressMain)

        if (savedInstanceState == null){
            val fragment = FragmentMain()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.placeholder, fragment, "main_fragment")
            ft.commit()
        }

    }

    override fun onBackPressed() {

        if (supportFragmentManager.backStackEntryCount != 0) {
            super.onBackPressed()
            return
        }

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finish()
            return
        }

        this.doubleBackToExitPressedOnce = true
        toast("Double press BACK to exit")
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}
