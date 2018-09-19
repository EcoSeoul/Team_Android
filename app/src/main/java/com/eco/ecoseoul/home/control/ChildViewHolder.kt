package com.eco.ecoseoul.home.control

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.eco.ecoseoul.R

/**
 * Created by minhyoung on 2018. 9. 19..
 */
class ChildViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var childText : TextView = itemView.findViewById(R.id.list_child_text)
    var childButton : ImageButton = itemView.findViewById(R.id.list_child_button)
    var childEditionalText : TextView = itemView.findViewById(R.id.list_child_editional_text)
}