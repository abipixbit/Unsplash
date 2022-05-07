package com.example.splashexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.splashexample.model.data.UnsplashDataResponse
import com.example.splashexample.model.data.UnsplashErrorResponse
import com.example.splashexample.model.network.Repository

class UnsplashViewModel : ViewModel() {


    var splashImageResponse = MutableLiveData<List<UnsplashDataResponse.UnsplashDataResponseItem>>()
    val repository = Repository()
    val errorResponse = repository.errorResponse

    fun getphotos() : MutableLiveData<List<UnsplashDataResponse.UnsplashDataResponseItem>>{
        splashImageResponse = repository.loadImage()
        return splashImageResponse
    }

}
