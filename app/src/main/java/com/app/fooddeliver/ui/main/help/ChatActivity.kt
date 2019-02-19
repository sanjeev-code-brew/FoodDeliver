package com.app.fooddeliver.ui.main.help

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.base.BaseActivity
import com.app.fooddeliver.utils.CommonMethods
import com.app.fooddeliver.utils.YesNoDialogListener
import kotlinx.android.synthetic.main.toolbar_layout.*

class ChatActivity : BaseActivity(), View.OnClickListener, YesNoDialogListener {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ChatActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getContentId(): Int {
        return R.layout.activity_chat
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initListener()
    }

    fun initViews() {
        ivRight.visibility = View.VISIBLE
        tvHeaderTitle.text = getString(R.string.chat)
        ivRight.setImageResource(R.drawable.ic_call)
    }

    fun initListener() {
        ivBack.setOnClickListener(this)
        ivRight.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            ivBack.id -> onBackPressed()

            ivRight.id -> {
                CommonMethods.commonDialog("call",this,this)
            }
        }
    }

    override fun onYesClicked() {

    }

    override fun onNoClicked() {

    }
}
