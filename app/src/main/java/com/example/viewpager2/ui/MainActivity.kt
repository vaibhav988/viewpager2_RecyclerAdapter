package com.example.viewpager2.ui

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewpager2.DataModel.image
import com.example.viewpager2.R
import com.example.viewpager2.Repository.ImageRepo
import com.example.viewpager2.adapter.ViewPagerAdapter
import com.example.viewpager2.databinding.ActivityMainBinding
import com.example.viewpager2.viewmodel.ImageViewModel
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.viewpager2.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(mainBinding.tabLayout, mainBinding.viewpager2) { tab, position ->
            run {
                when (position) {
                    0 -> {
                        tab.text = "birds"
                        tab.setIcon(R.drawable.bird)

                    }
                    1 -> {
                        tab.text = "animals"
                        tab.setIcon(R.drawable.pawprint)

                    }
                    2 -> {
                        tab.text = "flowers"
                        tab.setIcon(R.drawable.flower)
                    }
                    3 -> {
                        tab.text = "water"
                        tab.setIcon(R.drawable.wave)
                    }
                }
            }
        }.attach()
    }
}