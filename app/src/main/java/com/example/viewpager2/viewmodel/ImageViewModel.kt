package com.example.viewpager2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewpager2.dataModel.image
import com.example.viewpager2.repository.ImageRepo
import kotlinx.coroutines.launch

class ImageViewModel() : ViewModel() {

    var listImages = MutableLiveData<List<image>>()
    private val imageRepo = ImageRepo()

    fun getImages(string :String)
    {
        viewModelScope.launch {
          listImages.postValue(imageRepo.getImages(string))
        }
    }

}