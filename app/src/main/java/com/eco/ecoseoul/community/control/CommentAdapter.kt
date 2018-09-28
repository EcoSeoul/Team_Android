package com.eco.ecoseoul.community.control

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.eco.ecoseoul.R
import com.eco.ecoseoul.community.model.CommentPost

class CommentAdapter(val comment_post : ArrayList<CommentPost>) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.comments_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.comment_name.text = comment_post[position].user_ID
        holder.comment_content.text = comment_post[position].cmt_content
        holder.comment_date.text = comment_post[position].cmt_date

    }

    override fun getItemCount() = comment_post.size


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val comment_name : TextView = itemView.findViewById<View>(R.id.comment_name) as TextView
        val comment_content : TextView = itemView.findViewById<View>(R.id.comment_content) as TextView
        val comment_date : TextView = itemView.findViewById<View>(R.id.comment_date) as TextView

    }


}