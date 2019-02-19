package com.app.fooddeliver.ui.main.rateorder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_rate_order.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class RateOrderActivity : BaseActivity(), View.OnClickListener {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, RateOrderActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getContentId(): Int {
        return R.layout.activity_rate_order
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initListener()
    }

    fun initViews() {
        tvHeaderTitle.text = getString(R.string.rate_order)
    }

    fun initListener() {
        ivBack.setOnClickListener(this)
        tvSubmit.setOnClickListener { this }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            ivBack.id -> onBackPressed()

            tvSubmit.id -> {

            }
        }
    }
}
