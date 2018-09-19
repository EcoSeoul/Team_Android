package com.eco.ecoseoul.home.control

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.eco.ecoseoul.R

/**
 * Created by minhyoung on 2018. 9. 19..
 */
class TextViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    var text : TextView = itemView.findViewById(R.id.item_text)
}