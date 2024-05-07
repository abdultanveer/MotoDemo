package com.example.motodemo.network

import com.squareup.moshi.Json


data class MarsPhoto(
    val id: String,
    @Json(name = "img_src")
    val imgSrc: String

)