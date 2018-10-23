package com.nikolaenko.andrew.myapplication

import android.app.Application
import com.github.salomonbrys.kodein.*
import com.nikolaenko.andrew.myapplication.network.ApiPublicService
import com.nikolaenko.andrew.myapplication.network.RetrofitFactory
import org.jetbrains.anko.ctx


class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        bind<ApiPublicService>() with provider { RetrofitFactory.getForPublic(ctx.getString(R.string.api_base_url)).create(ApiPublicService::class.java) }
    }
}
