package com.eco.ecoseoul.home.control

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.eco.ecoseoul.R

/**
 * Created by minhyoung on 2018. 9. 26..
 */
class UsageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var usageImage : ImageView = itemView.findViewById(R.id.all_item_usage_image)
    var monthText : TextView = itemView.findViewById(R.id.all_item_month_text)
    var arrowImage : ImageView = itemView.findViewById(R.id.all_item_arrow_image)
    var usageText : TextView = itemView.findViewById(R.id.all_item_usage_text)
    var percentageText : TextView = itemView.findViewById(R.id.all_item_percentage_text)
    var mentText : TextView = itemView.findViewById(R.id.all_item_ment_text)
}