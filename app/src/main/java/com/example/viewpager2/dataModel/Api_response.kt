package com.example.viewpager2.dataModel

import com.google.gson.annotations.SerializedName


data class Api_response (

  @SerializedName("total"     ) var total     : Int?            = null,
  @SerializedName("totalHits" ) var totalHits : Int?            = null,
  @SerializedName("hits"      ) var hits      :  ArrayList<image>
)