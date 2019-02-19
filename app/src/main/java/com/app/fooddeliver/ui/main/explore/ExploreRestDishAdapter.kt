package com.app.fooddeliver.ui.main.explore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.fooddeliver.R

class ExploreRestDishAdapter() : RecyclerView.Adapter<ExploreRestDishAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ExploreRestDishAdapter.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.explore_item_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: ExploreRestDishAdapter.ViewHolder, p1: Int) {
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}