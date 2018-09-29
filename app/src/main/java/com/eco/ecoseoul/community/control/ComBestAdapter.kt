package com.eco.ecoseoul.community.control

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.eco.ecoseoul.R
import com.eco.ecoseoul.community.model.BestPost

class ComBestAdapter(val best_post : ArrayList<BestPost>) : RecyclerView.Adapter<ComBestAdapter.ViewHolder>(){
    var itemClick : ItemClick? = null

    private var getItemClick : View.OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.community_best_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.com_best_title.text = best_post[position].board_title
        holder.com_best_contents.text = best_post[position].board_content
        holder.com_best_date.text = best_post[position].board_date
        holder.com_best_name.text = best_post[position].User_name
        holder.com_best_commentCount.text = best_post[position].board_cmtnum.toString()
        holder.com_best_likeCount.text = best_post[position].board_like.toString()

        Log.d("asdfasdfasdfasdf",best_post[position].likeFlag.toString())

        if(best_post[position].likeFlag == true){
            holder.com_best_like.setBackgroundResource(R.drawable.community_recommendation_color)
        } else {
            holder.com_best_like.setBackgroundResource(R.drawable.community_recommendation_line)
        }

        when(position){
            0->{
                holder.com_best_ic.setBackgroundResource(R.drawable.community_gold)
            }
            1->{
                holder.com_best_ic.setBackgroundResource(R.drawable.community_silver)
            }
            2->{
                holder.com_best_ic.setBackgroundResource(R.drawable.community_bronze)
            }
        }
        holder.itemView.setOnClickListener { v: View? ->
            val click = itemClick
            if(click != null){
                click.onClick(v!!,position)
            }
        }
    }

    override fun getItemCount() = best_post.size

    fun setOnItemClickListener(click : ItemClick){
        itemClick = click
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val com_best_title : TextView = itemView.findViewById<View>(R.id.com_best_title) as TextView
        val com_best_contents : TextView = itemView.findViewById<View>(R.id.com_best_contents) as TextView
        val com_best_date : TextView = itemView.findViewById<View>(R.id.com_best_date) as TextView
        val com_best_name : TextView = itemView.findViewById<View>(R.id.com_best_name) as TextView
        val com_best_ic : ImageView = itemView.findViewById(R.id.com_best_ic)
        val com_best_likeCount : TextView = itemView.findViewById<View>(R.id.com_best_likeCount) as TextView
        val com_best_commentCount : TextView = itemView.findViewById<View>(R.id.com_best_commentCount) as TextView
        val com_best_like : ImageView = itemView.findViewById<View>(R.id.com_best_like) as ImageView
    }

    interface ItemClick{
        fun onClick(view: View,position : Int)
    }

}