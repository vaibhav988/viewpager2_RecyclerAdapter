package com.example.viewpager2.repository

import com.example.viewpager2.dataModel.API
import com.example.viewpager2.dataModel.image
import com.example.viewpager2.retrofitService.ImageService
import com.example.viewpager2.retrofitService.RetrofitService

class ImageRepo {

    suspend fun getImages(filter : String): ArrayList<image>? {
        val images  = RetrofitService.getRetrofit().create(ImageService :: class.java).
        getImages(API.api_key ,  filter  , "photo")
        if(images.isSuccessful) {
           return images.body()?.hits
        }
        return null
    }

}