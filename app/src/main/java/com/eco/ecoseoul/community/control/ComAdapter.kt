package com.eco.ecoseoul.community.control

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.eco.ecoseoul.R
import com.eco.ecoseoul.community.model.AllPost

class ComAdapter(val post : ArrayList<AllPost>) : RecyclerView.Adapter<ComAdapter.ViewHolder>() {
    var itemClick : ItemClick? = null

    private  var getItemClick : View.OnClickListener?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.community_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.com_title.text = post[position].board_title
        holder.com_contents.text = post[position].board_content
        holder.com_date.text = post[position].board_date
        holder.com_name.text = post[position].User_name

        holder.itemView.setOnClickListener { v: View? ->
            val click = itemClick
            if(click != null) {
                click.onClick(v!!, position)
            }
        }

    }

    override fun getItemCount() = post.size

    fun setOnItemClickListener(click : ItemClick){
        itemClick = click
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val com_title : TextView = itemView.findViewById<View>(R.id.com_title) as TextView
        val com_contents : TextView = itemView.findViewById<View>(R.id.com_contents) as TextView
        val com_date : TextView = itemView.findViewById<View>(R.id.com_date) as TextView
        val com_name : TextView = itemView.findViewById<View>(R.id.com_name) as TextView
    }

    interface ItemClick{
        fun onClick(view : View, position: Int)
    }

}