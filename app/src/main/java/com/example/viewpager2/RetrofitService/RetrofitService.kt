package com.example.viewpager2.RetrofitService

import com.example.viewpager2.DataModel.API
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    fun getRetrofit():Retrofit{

        return Retrofit.Builder().baseUrl(API.base_url).addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}