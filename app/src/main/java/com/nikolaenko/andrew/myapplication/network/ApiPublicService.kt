package com.nikolaenko.andrew.myapplication.network

import com.nikolaenko.andrew.myapplication.model.ModelsResponse
import com.nikolaenko.andrew.myapplication.model.ResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiPublicService {

    @GET("stocks.json")
    fun getList(): Observable<ModelsResponse<ResponseModel>>
}
