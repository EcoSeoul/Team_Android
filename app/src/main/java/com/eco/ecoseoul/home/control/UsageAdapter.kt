package com.eco.ecoseoul.home.control

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.model.UsageItem

/**
 * Created by minhyoung on 2018. 9. 26..
 */
class UsageAdapter(var items : ArrayList<UsageItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view : View? = null
        var context : Context = parent!!.context

        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = inflater.inflate(R.layout.all_usage_item,parent,false)
        return UsageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var data = items.get(position)
        var usageHolder = holder as UsageViewHolder
        usageHolder.usageImage.setImageDrawable(data.image)
        usageHolder.monthText.text = data.month
        usageHolder.usageText.text = data.usage

    }
}