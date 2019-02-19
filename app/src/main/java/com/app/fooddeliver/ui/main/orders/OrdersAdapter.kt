package com.app.fooddeliver.ui.main.orders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.fooddeliver.R
import com.app.fooddeliver.ui.main.rateorder.RateOrderActivity
import com.app.fooddeliver.ui.main.trackorder.TrackOrderActivity
import com.app.fooddeliver.utils.PAST
import com.app.fooddeliver.utils.UPCOMING
import kotlinx.android.synthetic.main.order_items_layout.*
import kotlinx.android.synthetic.main.order_items_layout.view.*

class OrdersAdapter(val type: String, var context: Context) : RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.order_items_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        viewHolder.bindViews()

        viewHolder.btnRateOrder.setOnClickListener {
            RateOrderActivity.start(context)
        }

        viewHolder.tvTrack.setOnClickListener {
            TrackOrderActivity.start(context)
        }
    }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

      val tvDelivered = itemView.tvDelivered
      val tvTrack = itemView.tvTrack
      val tvReorder = itemView.tvReorder
      val btnGetHelp = itemView.btnGetHelp
      val btnRateOrder = itemView.btnRateOrder

        fun bindViews() {


            if (type.equals(UPCOMING)){
                tvDelivered.text = context.getString(R.string.preparing_order)

                tvTrack.visibility = View.VISIBLE
                tvReorder.visibility = View.GONE
                btnGetHelp.visibility = View.VISIBLE
                btnRateOrder.visibility = View.GONE
            }else if (type.equals(PAST)){

                tvDelivered.text = context.getString(R.string.delivered)

                tvTrack.visibility = View.GONE
                tvReorder.visibility = View.VISIBLE
                btnGetHelp.visibility = View.GONE
                btnRateOrder.visibility = View.VISIBLE
            }
        }
    }
}