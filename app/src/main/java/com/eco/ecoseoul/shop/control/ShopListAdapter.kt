package com.eco.ecoseoul.shop.control

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.eco.ecoseoul.R
import com.eco.ecoseoul.shop.model.ShopItem

/**
 * Created by minhyoung on 2018. 9. 29..
 */
class ShopListAdapter(var items : ArrayList<ShopItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var itemClick : ItemClick? = null

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        context = parent!!.context
        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view : View = inflater.inflate(R.layout.shop_list_item,parent,false)

        return ShopListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var viewHolder = holder as ShopListViewHolder
        var data = items.get(position)

        viewHolder.goodsText.text = data.goods_name
        Glide.with(context).load(data.goods_img).into(viewHolder.goodsImage)

        holder.itemView.setOnClickListener{ v: View? ->
            val onclick = itemClick
            if(onclick != null){
                onclick.onClick(v!!,position)
            }
        }

    }

    fun setOnItemClickListener(click : ItemClick){
        itemClick = click
    }

    interface ItemClick{
        fun onClick(view: View,position : Int)
    }
}