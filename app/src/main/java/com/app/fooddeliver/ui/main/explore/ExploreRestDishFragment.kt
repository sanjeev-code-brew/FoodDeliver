package com.app.fooddeliver.ui.main.explore

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.app.fooddeliver.R
import kotlinx.android.synthetic.main.explore_frag_layout.*

class ExploreRestDishFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.explore_frag_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    fun initAdapter() {
        val adapter = ExploreRestDishAdapter();
        val layoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerViewRestDish.layoutManager = layoutManager
        recyclerViewRestDish.adapter = adapter;
    }
}