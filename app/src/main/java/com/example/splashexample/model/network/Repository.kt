package com.example.splashexample.model.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.splashexample.model.data.UnsplashDataResponse
import com.example.splashexample.model.data.UnsplashErrorResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    val splashImageResponse = MutableLiveData<List<UnsplashDataResponse.UnsplashDataResponseItem>>()
    var errorResponse = MutableLiveData<UnsplashErrorResponse>()


    fun loadImage() : MutableLiveData<List<UnsplashDataResponse.UnsplashDataResponseItem>> {

    RetrofitObject.getRetrofit().getPhotos((1..10).random()).enqueue(object : Callback<List<UnsplashDataResponse.UnsplashDataResponseItem>?> {
        override fun onResponse(
            call: Call<List<UnsplashDataResponse.UnsplashDataResponseItem>?>,
            response: Response<List<UnsplashDataResponse.UnsplashDataResponseItem>?>
        ) {
            if (response.isSuccessful) {
                splashImageResponse.value = response.body()
            }
            else if (response.raw().code.equals(401)) {
                Log.d("Repo1",response.raw().code.toString())
                Log.d("Repo1",response.raw().toString())
                Log.d("Repo1",response.errorBody().toString())
                errorResponse.value = UnsplashErrorResponse("Unauthorized")

            }
        }

        override fun onFailure(
            call: Call<List<UnsplashDataResponse.UnsplashDataResponseItem>?>,
            t: Throwable
        ) {
            Log.d("Repo",t.message!!)
            errorResponse.value = UnsplashErrorResponse(t.message.toString())
        }
    })

        return splashImageResponse

    }



}