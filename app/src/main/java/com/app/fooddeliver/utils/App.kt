package com.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.helpo.utils.PrefsManager

class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var mContext : Context? = null

        fun getContext(): Context? {
            return mContext
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        PrefsManager.initialize(this)
        mContext = applicationContext
    }

}