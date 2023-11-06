package com.example.peopleapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PersonDto (
   @Json(name = "name")
    val name : String,
   @Json(name = "picture")
    val picture : Picture,
   @Json(name = "nat")
    val nationality : String
)

@JsonClass(generateAdapter = true)
data class Picture(
    val large : String,
    val medium : String,
    val thumbnail : String
)

@JsonClass(generateAdapter = true)
data class Name (
    val title : String,
    val first : String,
    val last : String
)

