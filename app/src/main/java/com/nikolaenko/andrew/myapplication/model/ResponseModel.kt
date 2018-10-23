package com.nikolaenko.andrew.myapplication.model

import com.google.gson.annotations.SerializedName

class ResponseModel {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("price")
    var price: PriceModel? = null

    @SerializedName("percent_change")
    var percentChange: Double? = null

    @SerializedName("volume")
    var volume: Int? = null

    @SerializedName("symbol")
    var symbol: String? = null
}
