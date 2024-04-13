package com.example.chucknorrisfacts

import com.google.gson.annotations.SerializedName

data class Fact (

    @SerializedName("icon_url")
    val iconUrl: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("value")
    val value: String,

)