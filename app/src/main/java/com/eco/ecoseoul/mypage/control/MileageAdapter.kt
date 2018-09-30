package com.eco.ecoseoul.mypage.control

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eco.ecoseoul.R
import com.eco.ecoseoul.mypage.model.MileageUsageData
import kotlinx.android.synthetic.main.list_item_mileage.view.*

class MileageAdapter(val mileageList: ArrayList<MileageUsageData>) : RecyclerView.Adapter<MileageAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return mileageList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_mileage, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(mileageList[position])
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bindItems(data: MileageUsageData) {

            /*Glide.with(item.context).load(data.mileage_image).into(list_item_mileage.iv_mileage_image)*/
            itemView.tv_mileage_content.text = data.mileage_usage
            itemView.tv_mileage_date.text = data.mileage_date
            if (data.mileage_deposit == null) {
                itemView.imageView3.setImageResource(R.drawable.my_mileage_use)
                itemView.tv_mileage_count.setTextColor(Color.parseColor("#FF8888"))
                itemView.tv_mileage_count.text = "-" + data.mileage_withdraw
            } else {
                itemView.imageView3.setImageResource(R.drawable.my_mileage_save)
                itemView.tv_mileage_count.setTextColor(Color.parseColor("#26D07C"))
                itemView.tv_mileage_count.text = "+" + data.mileage_deposit
            }
        }
    }

}