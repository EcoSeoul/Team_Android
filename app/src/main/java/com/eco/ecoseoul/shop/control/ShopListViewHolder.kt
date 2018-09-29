package com.eco.ecoseoul.shop.control

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.eco.ecoseoul.R

/**
 * Created by minhyoung on 2018. 9. 29..
 */
class ShopListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var goodsImage : ImageView = itemView.findViewById(R.id.shop_item_image)
    var goodsText : TextView = itemView.findViewById(R.id.shop_item_text)
}