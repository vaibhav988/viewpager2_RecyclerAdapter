package com.example.viewpager2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewpager2.DataModel.image
import com.example.viewpager2.Repository.ImageRepo
import kotlinx.coroutines.launch

class ImageViewModel(val imageRepo: ImageRepo) : ViewModel() {

    var listImages = MutableLiveData<List<image>>()

    fun getImages(string :String)
    {
        viewModelScope.launch {
          listImages.postValue(imageRepo.getImages(string))
        }
    }

}