package com.app.fooddeliver.ui.main.address

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.app.fooddeliver.R
import kotlinx.android.synthetic.main.address_item_layout.view.*

class SavedAddressAdapter(context: Context) : RecyclerView.Adapter<SavedAddressAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.address_item_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}