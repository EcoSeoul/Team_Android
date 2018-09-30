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
import com.eco.ecoseoul.mypage.model.MyGoods


class GoodsAdapter(val goods : ArrayList<MyGoods>) : RecyclerView.Adapter<GoodsAdapter.ViewHolder>() {

    lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.request_list_ltem, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount() = goods.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.request_name.text = goods[position].goods_name
        holder.request_date.text = goods[position].mileage_date
        Glide.with(context).load(goods[position].goods_img).into(holder.request_img)


    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val request_name : TextView = itemView.findViewById<View>(R.id.request_name) as TextView
        val request_date : TextView = itemView.findViewById<View>(R.id.request_date) as TextView
        val request_img : ImageView = itemView.findViewById<View>(R.id.request_img) as ImageView
    }

}