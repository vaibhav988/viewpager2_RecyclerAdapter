package com.example.viewpager2.retrofitService

import com.example.viewpager2.dataModel.Api_response
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {

//key=28989289-71b0f6312e2a609012e26df74&q=yellow+flowers&image_type=photo

    @GET("api/")
    suspend fun getImages(@Query("key") api : String , @Query("q") filter : String ,@Query("image_type") type : String):
            Response<Api_response>

}