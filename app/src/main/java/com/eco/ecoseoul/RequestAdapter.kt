package com.eco.ecoseoul

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RequestAdapter(val requestList: ArrayList<RequestItem>) : RecyclerView.Adapter<RequestAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder?, p1: Int) {
        val request : RequestItem = requestList[p1]

        p0?.requestName?.text = request.requestTitle
        p0?.requestDate?.text = request.requestDate
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.request_list_ltem, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return requestList.size
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val requestName = itemView.findViewById<View>(R.id.request_name) as TextView
        val requestDate = itemView.findViewById<View>(R.id.request_date) as TextView
    }
}