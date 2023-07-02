package com.example.select_img_from_gallery_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.select_img_from_gallery_android.View.adapters.ViewPagerAdapter
import com.example.select_img_from_gallery_android.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private val tabTitleArray = arrayOf("","","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()



    }
}