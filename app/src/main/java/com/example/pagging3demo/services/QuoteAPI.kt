package com.example.pagging3demo.services

import com.example.pagging3demo.models.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): QuoteList
}