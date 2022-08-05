package com.example.viewpager2.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.viewpager2.R
import com.example.viewpager2.adapter.ViewpagerAdapter
import com.example.viewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var list: List<String>

    @RequiresApi(Build.VERSION_CODES.M)
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        connectViews()
    }

    fun connectViews() {
        list = resources.getStringArray(R.array.filterListNames).asList()
        mainBinding.viewpager2.adapter = ViewpagerAdapter(list, applicationContext, this)
        TabLayoutMediator(mainBinding.tabLayout, mainBinding.viewpager2) { tab, position ->
            run {
                when (position) {
                    0 -> {
                        tab.text = resources.getStringArray(R.array.filterListNames)[0]
                        tab.setIcon(R.drawable.bird)

                    }
                    1 -> {
                        tab.text = resources.getStringArray(R.array.filterListNames)[1]
                        tab.setIcon(R.drawable.pawprint)

                    }
                    2 -> {
                        tab.text = resources.getStringArray(R.array.filterListNames)[2]
                        tab.setIcon(R.drawable.flower)
                    }
                    3 -> {
                        tab.text = resources.getStringArray(R.array.filterListNames)[3]
                        tab.setIcon(R.drawable.wave)
                    }
                }
            }
        }.attach()
    }
}