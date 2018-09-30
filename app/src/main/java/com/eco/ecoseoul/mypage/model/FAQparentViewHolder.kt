package com.eco.ecoseoul.mypage.model

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.model.ParentItem
import kotlinx.android.synthetic.main.faq_parent_item.view.*

/**
 * Created by minhyoung on 2018. 9. 30..
 */
class FAQparentViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    var parentText = itemView.findViewById<View>(R.id.parent_text) as TextView
    var parentImage = itemView.findViewById<View>(R.id.parent_image) as ImageView
    lateinit var refferalItem : FAQItem

}