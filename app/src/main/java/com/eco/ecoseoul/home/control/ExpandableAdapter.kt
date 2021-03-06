package com.eco.ecoseoul.home.control

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.model.ParentItem
import java.util.ArrayList
import android.R.attr.data
import android.content.ClipData.Item
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast


/**
 * Created by minhyoung on 2018. 9. 19..
 */
class ExpandableAdapter(var items : ArrayList<ParentItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private final var PARENT : Int = 0
    private final var TEXT : Int = 1
    private final var CHILD : Int = 2

    lateinit var context : Context


    override fun getItemViewType(position: Int): Int {
        return items.get(position).type
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var view : View? = null
        context  = parent!!.context


        when(viewType){
            PARENT -> {
                var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.list_item_parent,parent,false)
                var viewHolder = ParentViewHolder(view)
                return viewHolder
            }

            TEXT -> {
                var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.list_item_text,parent,false)
                var viewHolder = TextViewHolder(view)
                return viewHolder
            }

            CHILD -> {
                var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.list_item_child,parent,false)
                var viewHolder = ChildViewHolder(view)


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

        when(data.type){
            PARENT -> {
                var parentHolder = holder as ParentViewHolder
                parentHolder.refferalItem = data
                parentHolder.parentText.text = data.parentText

                parentHolder.parentButton.setOnClickListener { v: View? ->
                    if(data.invisibleChildren == null){
                        Log.d("Parent","null")
                        data.invisibleChildren = ArrayList<ParentItem>()
                        var count = 0
                        var pos = items.indexOf(parentHolder.refferalItem)
                        while(items.size > pos + 1 && items.get(pos+1).type != PARENT){
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

            TEXT -> {
                var textHolder = holder as TextViewHolder
                textHolder.text.text = data.parentText
            }

            CHILD -> {
                var childHolder = holder as ChildViewHolder
                childHolder.childText.text = data.parentText
                childHolder.childButton.setOnClickListener { v : View ->
                    when(position){
                        2->{
                            Log.d("expandable","top")
                            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://topshop.bccard.com/app/topmall/m/main/main"))
                            context.startActivity(intent)
                        }
                        4->{
                            Log.d("expandable","engine")
                            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/EngineDoctorQ"))
                            context.startActivity(intent)
                        }
                        5->{
                            Log.d("expandable","friend")
                            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.honest79.co.kr/?NaPm=ct%3Djmg9y1xo%7Cci%3Dcheckout%7Ctr%3Dds%7Ctrx%3D%7Chk%3Dbacd7b5c5fd5e888ce084b1072028c6563584fa9"))
                            context.startActivity(intent)
                        }
                    }

                }
                if(data.editionalText != null){
                    childHolder.childEditionalText.text = data.editionalText
                    childHolder.childEditionalText.visibility = View.VISIBLE
                } else {
                    childHolder.childEditionalText.visibility = View.GONE
                }
            }
        }

    }
}