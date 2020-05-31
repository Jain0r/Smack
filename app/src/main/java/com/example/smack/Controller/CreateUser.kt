package com.example.smack.Controller

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.smack.R
import com.example.smack.Services.AuthService
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUser : AppCompatActivity() {

    var useAvatar = "profiledefault"
    var avatarColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun generateUserAvatar(view: View){
        val random = Random()
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        if (color == 0) {
            useAvatar = "light$avatar"
        }else{
            useAvatar = "dark$avatar"
        }

        val resourceId = resources.getIdentifier(useAvatar, "drawable", packageName)
        createAvatarImagenView.setImageResource(resourceId)

    }

    fun generateColorClicked(view: View){
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImagenView.setBackgroundColor(Color.rgb(r,g,b))
        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor= "[$savedR, $savedG, $savedB, 1]"
        //println(avatarColor)

    }

    fun createUserClicked(view: View){
        val email = createEmailText.text.toString()
        val password = createPasswordText.text.toString()
        AuthService.registerUser(this, email, password) {registerSuccess ->
            if (registerSuccess){
                AuthService.loginUser(this, email, password) {loginSuccess ->
                    if (loginSuccess){
                        println(AuthService.authToken)
                        println(AuthService.userEmail)
                    }
                }

            }
        }
    }
}
