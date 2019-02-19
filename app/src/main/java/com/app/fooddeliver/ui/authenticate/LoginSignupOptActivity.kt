package com.app.fooddeliver.ui.authenticate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.fooddeliver.R
import kotlinx.android.synthetic.main.activity_login_signup_opt.*

class LoginSignupOptActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup_opt)

        initListener()
    }

    fun initListener() {
        btnLogin.setOnClickListener(this)
        btnSignup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnLogin.id -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

            btnSignup.id -> {
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
