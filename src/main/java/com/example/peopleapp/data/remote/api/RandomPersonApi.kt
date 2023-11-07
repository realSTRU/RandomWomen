package com.example.peopleapp.data.remote.api

import com.example.peopleapp.data.remote.dto.Results
import retrofit2.http.GET

interface RandomPersonApi {
    @GET("?gender=female&?page=3&results=15&seed=abc")
    suspend fun getPerson(): Results
}