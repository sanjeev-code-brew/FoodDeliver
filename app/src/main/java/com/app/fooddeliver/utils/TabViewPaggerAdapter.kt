package com.app.fooddeliver.utils


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.util.*
import kotlin.collections.ArrayList

class TabViewPaggerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private var titles = ArrayList<String>()
    private var mFragmentList = ArrayList<Fragment>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return titles.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}