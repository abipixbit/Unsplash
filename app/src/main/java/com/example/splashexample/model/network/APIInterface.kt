package com.example.splashexample.model.network

import com.example.splashexample.BuildConfig
import com.example.splashexample.model.data.UnsplashDataResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import kotlin.random.Random

interface APIInterface {

@GET("photos")
suspend fun getPhotos
    (
    @Query("page") page : Int,
    @Query("per_page") perPage : Int = 10,
    @Header("Authorization") id : String = "Client-ID gSrqWzdLI8lvxEu07ybcwEINKvjjmtkCdh2RUkvVWCs"
    ) : Response<List<UnsplashDataResponse.UnsplashDataResponseItem>>

companion object retrofitObject {

    fun getApi() : APIInterface {

    val logging = HttpLoggingInterceptor()

      //Play Store
    if (BuildConfig.DEBUG) {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    } else {
        logging.setLevel(HttpLoggingInterceptor.Level.NONE)
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

        return Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(APIInterface::class.java)
    }
}
}



