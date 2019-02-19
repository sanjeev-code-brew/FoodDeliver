package com.app.fooddeliver.ui.main.explore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import com.app.fooddeliver.utils.TabViewPaggerAdapter
import kotlinx.android.synthetic.main.activity_explore.*
import kotlinx.android.synthetic.main.toolbar_layout.*


class ExploreActivity : BaseActivity(), View.OnClickListener {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ExploreActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getContentId(): Int {
        return R.layout.activity_explore
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initListener()
        setupViewPager(viewpager)
        tabLayout.setupWithViewPager(viewpager)
    }

    fun initViews() {
        tvHeaderTitle.text = getString(R.string.explore)

    }

    fun initListener() {
        ivBack.setOnClickListener(this)
    }


    fun setupViewPager(viewPager: ViewPager) {
        val adapter = TabViewPaggerAdapter(supportFragmentManager)
        adapter.addFragment(ExploreRestDishFragment(), getString(R.string.restaurants))
        adapter.addFragment(ExploreRestDishFragment(), getString(R.string.dishs))
        viewPager.adapter = adapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            ivBack.id -> onBackPressed()
        }
    }
}
