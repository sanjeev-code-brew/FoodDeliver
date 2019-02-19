package com.app.fooddeliver.ui.main.trackorder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_track_order.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class TrackOrderActivity : BaseActivity(), View.OnClickListener {

    var isOrderStatusVisible: Boolean = true

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, TrackOrderActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getContentId(): Int {
        return R.layout.activity_track_order
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initListener()
    }

    fun initViews() {
        tvHeaderTitle.text = getString(R.string.track_order)

    }

    fun initListener() {
        ivBack.setOnClickListener(this)
        tvOrderPicked.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            ivBack.id -> onBackPressed()

            tvOrderPicked.id -> {
                if (isOrderStatusVisible) {
                    isOrderStatusVisible = false
                    layoutOrderStatus.visibility = View.GONE
                    tvOrderPicked.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down, 0)
                } else {
                    isOrderStatusVisible = true
                    layoutOrderStatus.visibility = View.VISIBLE
                    tvOrderPicked.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_upward, 0)
                }
            }
        }
    }
}
