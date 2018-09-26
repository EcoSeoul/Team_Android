package com.eco.ecoseoul.mypage

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.eco.ecoseoul.R
import kotlinx.android.synthetic.main.list_item_mileage.view.*

class MileageAdapter(val mileageList: ArrayList<Mileage>) : RecyclerView.Adapter<MileageAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return mileageList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MileageAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_mileage, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MileageAdapter.ViewHolder, position: Int) {
        holder.bindItems(mileageList[position])
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bindItems(data : Mileage) {

            /*Glide.with(item.context).load(data.mileage_image).into(list_item_mileage.iv_mileage_image)*/
            itemView.tv_mileage_content.text = data.mileage_content
            itemView.tv_mileage_date.text = data.mileage_date
            itemView.tv_mileage_count.text = data.mileage_count
        }
    }

}