package com.example.splashexample.model.network

import com.example.splashexample.model.data.UnsplashDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIInterface {

@GET("photos")
fun getPhotos
    (
    @Query("page") page : Int = 10,
    @Query("per_page") perPage : Int = 100,
    @Header("Authorization") id : String = "Client-ID gSrqWzdLI8lvxEu07ybcwEINKvjjmtkCdh2RUkvVWCs"
    ) : Call<List<UnsplashDataResponse.UnsplashDataResponseItem>>

}
