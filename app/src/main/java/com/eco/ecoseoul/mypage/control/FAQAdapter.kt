package com.eco.ecoseoul.mypage.control

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.control.ChildViewHolder
import com.eco.ecoseoul.home.control.ParentViewHolder
import com.eco.ecoseoul.home.control.TextViewHolder
import com.eco.ecoseoul.home.model.ParentItem
import com.eco.ecoseoul.mypage.model.FAQChildViewHolder
import com.eco.ecoseoul.mypage.model.FAQItem
import com.eco.ecoseoul.mypage.model.FAQparentViewHolder
import java.util.ArrayList

/**
 * Created by minhyoung on 2018. 9. 30..
 */
class FAQAdapter(var items : ArrayList<FAQItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var view : View? = null
        var context : Context = parent!!.context


        when(viewType){
            0 -> {
                var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.faq_parent_item,parent,false)
                var viewHolder = FAQparentViewHolder(view)
                return viewHolder
            }

            1 -> {
                var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.faq_child_item,parent,false)
                var viewHolder = FAQChildViewHolder(view)
                return viewHolder
            }
        }
        return null
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var data = items.get(position)
        when(data.flag){
            0->{
                var parentHolder = holder as FAQparentViewHolder

                parentHolder.parentText.text = data.text
                parentHolder.refferalItem = data

                parentHolder.parentImage.setOnClickListener {
                    if(data.invisibleChildren == null){
                        Log.d("Parent","null")
                        data.invisibleChildren = ArrayList<FAQItem>()
                        var count = 0
                        var pos = items.indexOf(parentHolder.refferalItem)
                        while(items.size > pos + 1 && items.get(pos+1).flag != 0){
                            data.invisibleChildren!!.add(items.removeAt(pos+1))
                            count++
                        }
                        notifyItemRangeRemoved(pos+1,count)
                    } else {
                        Log.d("Parent","not null")
                        var pos = items.indexOf(parentHolder.refferalItem)
                        var index = pos+1
                        for (i in data.invisibleChildren!!) {
                            items.add(index,i)
                            index++
                        }

                        notifyItemRangeInserted(pos+1,index-pos-1)
                        data.invisibleChildren = null
                    }
                }
            }
            1->{
                var childHolder = holder as FAQChildViewHolder
                childHolder.childText.text = data.text
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items.get(position).flag
    }

}