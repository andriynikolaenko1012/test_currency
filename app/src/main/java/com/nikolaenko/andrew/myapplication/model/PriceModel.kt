package com.nikolaenko.andrew.myapplication.model

import com.google.gson.annotations.SerializedName

class PriceModel {

    @SerializedName("currency")
    var currency: String? = null

    @SerializedName("amount")
    var amount: Double? = 0.0
}
