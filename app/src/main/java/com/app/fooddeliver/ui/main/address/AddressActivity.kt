package com.app.fooddeliver.ui.main.address

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class AddressActivity : BaseActivity(), View.OnClickListener {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AddressActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getContentId(): Int {
        return R.layout.activity_address
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initListener()
        initAdapter()
    }

    fun initViews() {
        tvHeaderTitle.text = getString(R.string.addresses)
    }

    fun initListener() {
        ivBack.setOnClickListener(this)
    }

    fun initAdapter() {
        val adapter = SavedAddressAdapter(this);
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerViewAdd.layoutManager = layoutManager
        recyclerViewAdd.adapter = adapter;
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            ivBack.id -> onBackPressed()

            btnAddNew.id -> Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        }
    }
}
