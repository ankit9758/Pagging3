package com.example.pagging3demo.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagging3demo.pagging.QuotePagingSource
import com.example.pagging3demo.services.QuoteAPI
import javax.inject.Inject

class MainRepository @Inject constructor(private val quoteAPI: QuoteAPI){

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 60,enablePlaceholders=true),
        pagingSourceFactory = { QuotePagingSource(quoteAPI) }
    ).liveData
}