package com.example.smack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.smack.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun loginCreateUserBtnClicked(view : View){
        val createUserIntent = Intent(this, CreateUser::class.java)
        startActivity(createUserIntent)
    }
    fun loginLoginBtnClicked(view: View){

    }
}
