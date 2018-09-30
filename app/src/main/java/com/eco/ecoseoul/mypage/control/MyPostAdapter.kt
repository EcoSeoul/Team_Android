package com.eco.ecoseoul.mypage.control

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.eco.ecoseoul.R
import com.eco.ecoseoul.mypage.model.MyDonations
import com.eco.ecoseoul.mypage.model.MyGoods
import com.eco.ecoseoul.mypage.model.MyTextList


class MyPostAdapter(val mypost : ArrayList<MyTextList>) : RecyclerView.Adapter<MyPostAdapter.ViewHolder>() {

    lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.my_post_list_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount() = mypost.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.my_post_title.text = mypost[position].board_title
        holder.my_post_content.text = mypost[position].board_content
        holder.my_post_date.text = mypost[position].board_date
        holder.my_post_likeCount.text = mypost[position].board_like.toString()
        holder.my_post_cmtCount.text = mypost[position].board_cmtnum.toString()

//        if(mypost[position].)


    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val my_post_title : TextView = itemView.findViewById<View>(R.id.my_post_title) as TextView
        val my_post_content : TextView = itemView.findViewById<View>(R.id.my_post_content) as TextView
        val my_post_date : TextView = itemView.findViewById<View>(R.id.my_post_date) as TextView
        val my_post_likeCount : TextView = itemView.findViewById<View>(R.id.my_post_likeCount) as TextView
        val my_post_cmtCount : TextView = itemView.findViewById<View>(R.id.my_post_cmtCount) as TextView
        val mypost_like : ImageView = itemView.findViewById<View>(R.id.mypost_like) as ImageView
    }

}