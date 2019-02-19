package com.app.fooddeliver.ui.authenticate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import com.app.fooddeliver.ui.main.home.HomeActivity
import com.app.fooddeliver.utils.PREF_IS_LOGIN
import com.helpo.utils.PrefsManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.header_layout.*

class LoginActivity : BaseActivity(), View.OnClickListener {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getContentId(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initListener()
    }

    fun initListener() {
        ivBack.setOnClickListener(this)
        tvForgotPwd.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        tvSignup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            ivBack.id -> onBackPressed()

            tvForgotPwd.id -> Toast.makeText(this, "under development", Toast.LENGTH_SHORT).show()

            btnLogin.id -> {
                PrefsManager.get().save(PREF_IS_LOGIN,true)
                HomeActivity.start(this)
            }

            tvSignup.id -> SignupActivity.start(false, this)
        }
    }

}
