package com.example.splashexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.splashexample.model.network.APIInterface
import com.example.splashexample.model.network.PagingSource

class UnsplashViewModel(api : APIInterface) : ViewModel() {


//    var splashImageResponse = MutableLiveData<List<UnsplashDataResponse.UnsplashDataResponseItem>>()
//    val repository = Repository()
//    val errorResponse = repository.errorResponse

//    fun getphotos() : MutableLiveData<List<UnsplashDataResponse.UnsplashDataResponseItem>>{
//        splashImageResponse = repository.loadImage()
//        return splashImageResponse
//    }

    val unsplash = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = {PagingSource(api)}
    ) .flow.cachedIn(viewModelScope)

}
