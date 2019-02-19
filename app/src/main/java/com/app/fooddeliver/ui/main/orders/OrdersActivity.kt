package com.app.fooddeliver.ui.main.orders

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import com.app.fooddeliver.utils.PAST
import com.app.fooddeliver.utils.UPCOMING
import kotlinx.android.synthetic.main.activity_orders.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class OrdersActivity : BaseActivity(), View.OnClickListener {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, OrdersActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getContentId(): Int {
        return R.layout.activity_orders
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initListener()
        initAdapter(UPCOMING)
    }

    fun initViews() {
        tvHeaderTitle.text = getString(R.string.orders)
    }

    fun initListener() {
        ivBack.setOnClickListener(this)
        tvUpcoming.setOnClickListener(this)
        tvPast.setOnClickListener(this)
    }

    fun initAdapter(type: String) {
        val adapter = OrdersAdapter(type, this);
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerViewOrders.layoutManager = layoutManager
        recyclerViewOrders.adapter = adapter;
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            ivBack.id -> onBackPressed()

            tvUpcoming.id -> {
                tvUpcoming.setTextColor(resources.getColor(R.color.white))
                tvUpcoming.setBackgroundResource(R.drawable.rounded_pink_bg)
                tvPast.setTextColor(resources.getColor(R.color.search_text_color))
                tvPast.setBackgroundResource(R.drawable.rounded_order_btn_bg)

                initAdapter(UPCOMING)
            }

            tvPast.id -> {
                tvUpcoming.setTextColor(resources.getColor(R.color.search_text_color))
                tvUpcoming.setBackgroundResource(R.drawable.rounded_order_btn_bg)
                tvPast.setTextColor(resources.getColor(R.color.white))
                tvPast.setBackgroundResource(R.drawable.rounded_pink_bg)

                initAdapter(PAST)
            }
        }
    }
}
