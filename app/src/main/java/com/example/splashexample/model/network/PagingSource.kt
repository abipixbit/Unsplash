package com.example.splashexample.model.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.splashexample.model.data.UnsplashDataResponse
import java.lang.Exception

class PagingSource(val api : APIInterface) : PagingSource<Int, List<UnsplashDataResponse.UnsplashDataResponseItem>>() {

    override fun getRefreshKey(state: PagingState<Int, List<UnsplashDataResponse.UnsplashDataResponseItem>>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, List<UnsplashDataResponse.UnsplashDataResponseItem>> {

        val currentPage = params.key ?:1
        val response = api.getPhotos(currentPage)
        val data = response.body()
        val previousKey = if (currentPage ==1) {null}
        else {currentPage - 1}

        return LoadResult.Page(
            listOf(data!!),previousKey,currentPage+1
        )
    }


}