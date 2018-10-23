package com.nikolaenko.andrew.myapplication.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.github.salomonbrys.kodein.LazyKodein
import com.github.salomonbrys.kodein.android.appKodein
import com.github.salomonbrys.kodein.instance
import com.nikolaenko.andrew.myapplication.activity.MainActivity
import com.nikolaenko.andrew.myapplication.network.ApiPublicService

abstract class BaseFragment : Fragment() {

    protected val kodein = LazyKodein(appKodein)
    protected val apiPublicService = kodein.instance<ApiPublicService>()
    protected lateinit var mainActivity: MainActivity

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainActivity = activity as MainActivity
    }

    fun showProgress(show: Boolean) {
        mainActivity.progressView!!.visibility = if (show) View.VISIBLE else View.GONE
    }
}
