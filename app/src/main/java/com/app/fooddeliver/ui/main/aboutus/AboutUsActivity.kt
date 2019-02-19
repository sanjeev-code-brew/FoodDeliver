package com.app.fooddeliver.ui.main.aboutus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_about_us.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class AboutUsActivity : BaseActivity(), View.OnClickListener {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AboutUsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getContentId(): Int {
        return R.layout.activity_about_us
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initListener()
    }

    fun initViews() {
        tvHeaderTitle.text = getString(R.string.about_us)
    }

    fun initListener() {

        ivBack.setOnClickListener(this)
        tvAboutApp.setOnClickListener(this)
        tvTermConditions.setOnClickListener(this)
        tvPrivacyPolicy.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            ivBack.id -> onBackPressed()

            tvAboutApp.id -> Toast.makeText(this, "under development", Toast.LENGTH_SHORT).show()

            tvTermConditions.id -> Toast.makeText(this, "under development", Toast.LENGTH_SHORT).show()

            tvPrivacyPolicy.id -> Toast.makeText(this, "under development", Toast.LENGTH_SHORT).show()
        }
    }
}
