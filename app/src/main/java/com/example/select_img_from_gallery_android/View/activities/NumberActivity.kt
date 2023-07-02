package com.example.select_img_from_gallery_android.View.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.select_img_from_gallery_android.R
import com.example.select_img_from_gallery_android.databinding.ActivityNumberBinding
import com.google.firebase.auth.FirebaseAuth

class NumberActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            if(binding.phoneNumber.text!!.isEmpty()){
                Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show()
            }else{
                var intent = Intent(this, OTPActivity::class.java)
                // key : number / value : phoneNumber로 해서 다음 activity에서 받음
                intent.putExtra("number", binding.phoneNumber.text.toString())
                startActivity(intent)
                // 여기선 finish를 안함? 왜?
            }
        }

    }
}