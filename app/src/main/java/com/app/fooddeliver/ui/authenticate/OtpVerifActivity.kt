package com.app.fooddeliver.ui.authenticate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.app.fooddeliver.R
import com.goodiebag.pinview.Pinview
import kotlinx.android.synthetic.main.activity_otp_verif.*
import kotlinx.android.synthetic.main.header_layout.*

class OtpVerifActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verif)

        pinview.setPinViewEventListener(Pinview.PinViewEventListener { pinview, b ->
            Toast.makeText(this, "get all digits at same time " + pinview.value, Toast.LENGTH_SHORT).show()
        })

        ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}
