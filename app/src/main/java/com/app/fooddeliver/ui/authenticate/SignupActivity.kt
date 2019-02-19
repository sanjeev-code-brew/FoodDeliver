package com.app.fooddeliver.ui.authenticate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import com.app.fooddeliver.ui.main.home.HomeActivity
import com.app.fooddeliver.utils.EXTRA_ISFOR_UPDATE
import com.app.fooddeliver.utils.PREF_IS_LOGIN
import com.helpo.utils.PrefsManager
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.header_layout.*

class SignupActivity : BaseActivity(), View.OnClickListener {

    var isForUpdate = false

    companion object {
        fun start(isForUpdate: Boolean, context: Context) {
            val intent = Intent(context, SignupActivity::class.java)
            intent.putExtra(EXTRA_ISFOR_UPDATE, isForUpdate)
            context.startActivity(intent)
        }
    }

    override fun getContentId(): Int {
        return R.layout.activity_signup
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getData()
        initListener()
    }

    fun getData() {
        isForUpdate = intent.getBooleanExtra(EXTRA_ISFOR_UPDATE, false);
        if (isForUpdate) {
            tvLogin.text = getString(R.string.edit_profile)
            tlPwd.visibility = View.GONE
            btnRegister.text = getString(R.string.update)
            llLogin.visibility = View.GONE
            tvTermsConditions.visibility = View.GONE
        } else {
            tvLogin.text = getString(R.string.signup_caps)
            tlPwd.visibility = View.VISIBLE
            btnRegister.text = getString(R.string.register)
            llLogin.visibility = View.VISIBLE
            tvTermsConditions.visibility = View.VISIBLE
        }
    }

    fun initListener() {
        ivBack.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
        tvlogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            ivBack.id -> {
                onBackPressed()
            }
            tvlogin.id -> {
                LoginActivity.start(this)
            }

            btnRegister.id -> {
                PrefsManager.get().save(PREF_IS_LOGIN,true)
                HomeActivity.start(this)
            }
        }
    }
}
