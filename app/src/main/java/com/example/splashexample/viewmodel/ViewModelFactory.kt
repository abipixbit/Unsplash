package com.example.splashexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.splashexample.model.network.APIInterface
import java.lang.IllegalArgumentException

class ViewModelFactory (val api : APIInterface) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UnsplashViewModel::class.java)) {
            return UnsplashViewModel(api) as T
        }
        else {
            throw IllegalArgumentException("Not Found View Model")
        }
    }
}