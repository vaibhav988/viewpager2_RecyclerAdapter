package com.example.viewpager2.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.viewpager2.DataModel.API
import com.example.viewpager2.DataModel.image
import com.example.viewpager2.RetrofitService.ImageService
import com.example.viewpager2.RetrofitService.RetrofitService

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