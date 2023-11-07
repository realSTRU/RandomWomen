package com.example.peopleapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass



@JsonClass(generateAdapter = true)
data class Results(
    @Json(name = "results")
    val result : List<PersonDto>
)
@JsonClass(generateAdapter = true)
data class PersonDto (
   @Json(name = "name")
    val name : Name,
   @Json(name = "picture")
    val picture : Picture,
   @Json(name = "nat")
    val nationality : String
)

@JsonClass(generateAdapter = true)
data class Picture(
    @Json(name = "large")
    val large : String,
    @Json(name = "medium")
    val medium : String,
    @Json(name = "thumbnail")
    val thumbnail : String
)

@JsonClass(generateAdapter = true)
data class Name (
    @Json(name="title")
    val title : String,
    @Json(name="first")
    val first : String,
    @Json(name="last")
    val last : String
)

