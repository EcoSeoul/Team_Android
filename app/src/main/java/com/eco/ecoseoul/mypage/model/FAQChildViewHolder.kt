package com.eco.ecoseoul.mypage.model

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.eco.ecoseoul.R
import kotlinx.android.synthetic.main.faq_child_item.view.*

/**
 * Created by minhyoung on 2018. 9. 30..
 */
class FAQChildViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    var childText = itemView.findViewById<View>(R.id.faq_child_text) as TextView
}