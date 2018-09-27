package com.eco.ecoseoul.home.control

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.model.AllUsageItem

/**
 * Created by minhyoung on 2018. 9. 26..
 */
class UsageAdapter(var itemAlls : ArrayList<AllUsageItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view : View? = null
        var context : Context = parent!!.context

        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = inflater.inflate(R.layout.all_usage_item,parent,false)
        return UsageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemAlls.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var data = itemAlls.get(position)
        var usageHolder = holder as UsageViewHolder
        usageHolder.usageImage.setImageDrawable(data.image)
        usageHolder.monthText.text = data.month
        usageHolder.usageText.text = data.usage
        when(data.arrow){
            0->{
                usageHolder.arrowImage.setImageResource(R.drawable.percentage_down)
                usageHolder.mentText.text = "작년과 같은\r\n 사용량 이에요!"
            }
            1->{
                usageHolder.arrowImage.setImageResource(R.drawable.percentage_up)
                usageHolder.mentText.text = "절약 BAAAAAAD"
                usageHolder.percentageText.setTextColor(Color.parseColor("#FF8888"))
            }
            2->{
                usageHolder.arrowImage.setImageResource(R.drawable.percentage_down)
                usageHolder.mentText.text = "작년보다 "+data.percentage+"% 절약한 당신! 최고에요!"
            }
        }
        usageHolder.percentageText.text = data.percentage

    }
}