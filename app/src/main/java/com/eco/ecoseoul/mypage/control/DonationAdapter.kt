package com.eco.ecoseoul.mypage.control

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.eco.ecoseoul.R
import com.eco.ecoseoul.mypage.model.MyDonations
import com.eco.ecoseoul.mypage.model.MyGoods


class DonationAdapter(val donation : ArrayList<MyDonations>) : RecyclerView.Adapter<DonationAdapter.ViewHolder>() {

    lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.donation_list_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount() = donation.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.org_name.text = donation[position].org_name
        holder.donation_date.text = donation[position].mileage_date
        holder.mileage_withdraw.text = donation[position].mileage_withdraw.toString()


    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val org_name : TextView = itemView.findViewById<View>(R.id.org_name) as TextView
        val donation_date : TextView = itemView.findViewById<View>(R.id.donation_date) as TextView
        val mileage_withdraw : TextView = itemView.findViewById<View>(R.id.mileage_withdraw) as TextView
    }

}