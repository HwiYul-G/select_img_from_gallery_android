package com.example.select_img_from_gallery_android.View.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.example.select_img_from_gallery_android.databinding.ActivityProfileBinding
import com.example.select_img_from_gallery_android.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.util.Date

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var storage : FirebaseStorage
    private lateinit var selectedImg : Uri
    private lateinit var dialog : AlertDialog

    private lateinit var getResult : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 결과를 받기 위한 call back 등록
        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                if(it.data!!.data == null) {
                    selectedImg = it.data!!.data!!
                    binding.profileImage.setImageURI(selectedImg)
                }
            }
        }

        dialog = AlertDialog.Builder(this)
            .setMessage("Uploading...")
            .setCancelable(false).create()

        database = FirebaseDatabase.getInstance()
        storage = FirebaseStorage.getInstance()
        auth = FirebaseAuth.getInstance()

        binding.profileImage.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            /*
               startActivityForResult는 결과를 얻는 Activity를 실행하는 로직을 사용할 때, 메모리 부족으로 프로세스와 Activity가 사라질 수 있다.
               startActivityForResult를 통해 callback을 등록하고, onActivityResult에서 callback을 처리한다.
               두 메서드가 같은 곳에서 구현해야하는데, 메모리 부족으로 제대로 동작 안 할 수 있다.
               => Activity가 종료되었다가 다시 생성시 Activity에게 결과를 기다리는 중임을 다시 알려야 한다.
            */
            // startActivityForResult(intent,1)

            /*
                그래서 위의 방법 대신 새로운 API를 사용한다.
                Activity Result API는 다른 Activity를 실행하는 코드에서 결과 call back을 분리한다.
                Result Callback은 프로새스와 Activity 재 생성시 사용할 수 있어야 한다. 그러므로 다른 Activity를 실행하는 로직이 사용자 입력이나 비지니스 로직 기반으로 발생해도
                Activity 생성 시 callback을 무조건 등록해야 한다.

                registerForActivityResult()는 AcitivyResultContract 와 ActivityResultCallback을 가져와
                다른 Activity를 실행하는 데 사용할 ActivityResultLauncher를 반환한다.

                registerForActivityResult()는 콜백을 등록하는 역할을 한다. (register)
                따라서 ActivityResultLuancher와 registerForActivityResult() 메서드를 사용하면
                Activity가 종료되었다가 다시 생성되어도 결과를 기다리고 있다는 것을 알려줄 수 있는 것이다.

                새로운 API에서는 requestCode가 없는데 register를 실행해 result call back을 분리 구현하므로
                Activity를 구분할 필요가 없어졌다.
            */
            getResult.launch(intent)
        }

        binding.continueBtn.setOnClickListener {
            if(binding.userName.text!!.isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
            }else if(selectedImg == null){
                Toast.makeText(this,"Please select your profile image",Toast.LENGTH_SHORT).show()
            }else uploadData()
        }
    }

    private fun uploadData(){
        val reference = storage.reference.child("profile_pictures")
            .child(Date().time.toString())
        reference.putFile(selectedImg).addOnCompleteListener{
            if(it.isSuccessful){
                reference.downloadUrl.addOnSuccessListener {task->
                    uploadInfo(task.toString())
                }
            }
        }
    }

    private fun uploadInfo(imgUrl : String){
        val user = UserModel(auth.uid!!,
            binding.userName.text.toString(),
            auth.currentUser!!.phoneNumber.toString(),
            imgUrl
        )

        database.reference.child("users")
            .child(auth.uid.toString())
            .setValue(user)
            .addOnSuccessListener {
                Toast.makeText(this,"Data Insert",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
    }

}