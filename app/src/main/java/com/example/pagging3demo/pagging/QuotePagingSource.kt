package com.example.pagging3demo.pagging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagging3demo.services.QuoteAPI

class QuotePagingSource (private val quoteAPI: QuoteAPI) : PagingSource<Int, com.example.pagging3demo.models.Result>() {
    private val DEFAULT_PAGE_INDEX= 1
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.example.pagging3demo.models.Result> {
        return try {
            val position = params.key ?: DEFAULT_PAGE_INDEX
            val response = quoteAPI.getQuotes(position)

            return LoadResult.Page(
                data = response.results,
                prevKey = if (position == DEFAULT_PAGE_INDEX) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, com.example.pagging3demo.models.Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}