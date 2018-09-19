package com.eco.ecoseoul.home.control

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.eco.ecoseoul.R
import kotlinx.android.synthetic.main.list_item_parent.view.*

/**
 * Created by minhyoung on 2018. 9. 19..
 */
class ParentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var parentText : TextView = itemView.findViewById(R.id.parent_title_text)
    var parentButton : ImageButton = itemView.findViewById(R.id.parent_arrow_button)
}