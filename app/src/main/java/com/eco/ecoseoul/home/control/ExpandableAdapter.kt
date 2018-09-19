package com.eco.ecoseoul.home.control

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eco.ecoseoul.R
import java.util.ArrayList

/**
 * Created by minhyoung on 2018. 9. 19..
 */
class ExpandableAdapter(var items : ArrayList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private final var PARENT : Int = 0
    private final var TEXT : Int = 1
    private final var CHILD : Int = 2

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var view : View? = null
        var context : Context = parent!!.context


        when(viewType){
            PARENT -> {
                var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflater.inflate(R.layout.list_item_parent,parent,false)
                var viewHolder = ParentViewHolder(view)
                return viewHolder
            }

            TEXT -> {

            }

            CHILD -> {

            }
        }
        return null
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

    }
}