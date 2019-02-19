package com.app.fooddeliver.ui.authenticate

import android.os.Bundle
import android.os.Handler
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import com.app.fooddeliver.ui.main.home.HomeActivity

class SplashActivity : BaseActivity() {

    override fun getContentId(): Int {
        return R.layout.activity_splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        goNext()
    }

    fun goNext(){
        Handler().postDelayed({
           HomeActivity.start(this)
        },2000)
    }
}
