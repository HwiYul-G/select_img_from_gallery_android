package com.example.select_img_from_gallery_android.View.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.select_img_from_gallery_android.View.CallFragment
import com.example.select_img_from_gallery_android.View.ChatFragment
import com.example.select_img_from_gallery_android.View.StatusFragment
import com.example.select_img_from_gallery_android.View.adapters.ViewPagerAdapter
import com.example.select_img_from_gallery_android.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var auth : FirebaseAuth

    private val tabTitleArray = arrayOf("Chats","Status","Call")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인증되지 않은 사람의 경우. 인증하는 단계를 거치는 NumberActivity로 이동
        auth = FirebaseAuth.getInstance()
        if(auth.currentUser == null){
            startActivity(Intent(this, NumberActivity::class.java))
            finish()
        }


        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        // viewPager에 adapter를 연결 및 Fragment 추가하기
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle).apply {
            addFragment(ChatFragment(),"Chats")
            addFragment(StatusFragment(),"Status")
            addFragment(CallFragment(),"Call")
        }

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()



    }
}