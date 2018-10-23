package com.nikolaenko.andrew.myapplication.model

import com.google.gson.annotations.SerializedName

import java.util.Date

class ModelsResponse<T> {

    @SerializedName("stock")
    var data: List<T>? = null

    @SerializedName("as_of")
    var serverTime: Date? = null
}
