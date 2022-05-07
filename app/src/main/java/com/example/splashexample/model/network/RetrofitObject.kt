package com.example.splashexample.model.network

import com.example.splashexample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitObject {



    fun getRetrofit() : APIInterface {


        val logging = HttpLoggingInterceptor()

//      Play Store
        if (BuildConfig.DEBUG)
        {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        else
        {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return  Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(APIInterface::class.java)
    }
}