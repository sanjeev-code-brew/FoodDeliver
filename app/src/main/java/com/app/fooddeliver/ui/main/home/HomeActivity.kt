package com.app.fooddeliver.ui.main.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.authenticate.LoginActivity
import com.app.fooddeliver.ui.authenticate.SignupActivity
import com.app.fooddeliver.ui.base.BaseActivity
import com.app.fooddeliver.ui.main.aboutus.AboutUsActivity
import com.app.fooddeliver.ui.main.address.AddressActivity
import com.app.fooddeliver.ui.main.explore.ExploreActivity
import com.app.fooddeliver.ui.main.help.ChatActivity
import com.app.fooddeliver.ui.main.orders.OrdersActivity
import com.app.fooddeliver.utils.*
import com.helpo.utils.PrefsManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*

class HomeActivity : BaseActivity(), View.OnClickListener, LanguageListener {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

    }

    override fun getContentId(): Int {
        return R.layout.activity_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        initViews()
    }

    fun initViews() {

        val header: View = navView.getHeaderView(0)
        val txtLogin: TextView = header.findViewById(R.id.tvLogin)
        val txtRegister: TextView = header.findViewById(R.id.tvRegister)
        val ivEditProfile: ImageView = header.findViewById(R.id.ivEdit)

        val layoutLoginRegister: LinearLayout = header.findViewById(R.id.layoutLoginRegister)
        val layoutUserProfile: ConstraintLayout = header.findViewById(R.id.layoutProfile)

        val relExplore: RelativeLayout = header.findViewById(R.id.rlExplore)
        val relOrders: RelativeLayout = header.findViewById(R.id.rlOrders)
        val relAddress: RelativeLayout = header.findViewById(R.id.rlAddress)
        val relLanguage: RelativeLayout = header.findViewById(R.id.rlLanguage)
        val relHelp: RelativeLayout = header.findViewById(R.id.rlHelp)
        val relAboutUs: RelativeLayout = header.findViewById(R.id.rlAboutUs)

        if (PrefsManager.get().getBoolean(PREF_IS_LOGIN, false)) {
            layoutUserProfile.visibility = View.VISIBLE
            layoutLoginRegister.visibility = View.GONE

            relExplore.visibility = View.VISIBLE
            relOrders.visibility = View.VISIBLE
            relAddress.visibility = View.VISIBLE
            relLanguage.visibility = View.VISIBLE
            relHelp.visibility = View.VISIBLE
            relAboutUs.visibility = View.VISIBLE
        } else {
            layoutUserProfile.visibility = View.GONE
            layoutLoginRegister.visibility = View.VISIBLE

            relExplore.visibility = View.VISIBLE
            relOrders.visibility = View.GONE
            relAddress.visibility = View.GONE
            relLanguage.visibility = View.VISIBLE
            relHelp.visibility = View.VISIBLE
            relAboutUs.visibility = View.VISIBLE
        }

        txtLogin.setOnClickListener(this)
        txtRegister.setOnClickListener(this)
        ivEditProfile.setOnClickListener(this)
        relExplore.setOnClickListener(this)
        relOrders.setOnClickListener(this)
        relAddress.setOnClickListener(this)
        relLanguage.setOnClickListener(this)
        relHelp.setOnClickListener(this)
        relAboutUs.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            tvLogin.id -> {
                LoginActivity.start(this)
                closeDrawer()
            }

            tvRegister.id -> {
                SignupActivity.start(false, this)
                closeDrawer()
            }

            ivEdit.id -> {
                SignupActivity.start(true, this)
                closeDrawer()
            }

            rlExplore.id -> {
                ExploreActivity.start(this)
                closeDrawer()
            }

            rlOrders.id -> {
                OrdersActivity.start(this)
                closeDrawer()
            }

            rlAddress.id -> {
                AddressActivity.start(this)
                closeDrawer()
            }

            rlLanguage.id -> {
                if (PrefsManager.get().getString(PREF_LANG, "").equals("") ||
                    PrefsManager.get().getString(PREF_LANG, "").equals(PREF_ENG)
                ) {
                    PrefsManager.get().save(PREF_LANG, PREF_ENG)
                    CommonMethods.languagedialog(true, this, this)
                } else if (PrefsManager.get().getString(PREF_LANG, "").equals(PREF_ARABIC)) {
                    CommonMethods.languagedialog(false, this, this)
                }
            }

            rlHelp.id -> {
                ChatActivity.start(this)
                closeDrawer()
            }

            rlAboutUs.id -> {
                closeDrawer()
                AboutUsActivity.start(this)
            }
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun closeDrawer() {
        drawer_layout.closeDrawer(GravityCompat.START)
    }

    override fun englishSelected() {
        PrefsManager.get().save(PREF_LANG, PREF_ENG)
    }

    override fun arabicSelected() {
        PrefsManager.get().save(PREF_LANG, PREF_ARABIC)
    }
}
