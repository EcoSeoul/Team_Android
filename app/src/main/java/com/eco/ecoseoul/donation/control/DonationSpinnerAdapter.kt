package com.eco.ecoseoul.donation.control

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.eco.ecoseoul.R

/**
 * Created by minhyoung on 2018. 9. 27..
 */
class DonationSpinnerAdapter(var context : Context, var spinnerList : Array<String>,var donateButton : Button) : BaseAdapter() {
    val mInflater : LayoutInflater = LayoutInflater.from(context)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemRowHolder
        if (convertView == null) {
            view = mInflater!!.inflate(R.layout.donation_spinner_normal, parent, false)
            vh = ItemRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemRowHolder
        }

        val params = view.layoutParams

        view.layoutParams = params

        vh.label.text = spinnerList.get(position)

        when(position){
            0->{
                donateButton.setTextColor(Color.parseColor("#26D07C"))
                donateButton.setBackgroundResource(R.drawable.donation_button_background)
            }
            1->{
                donateButton.setTextColor(Color.parseColor("#FFFFFF"))
                donateButton.setBackgroundResource(R.drawable.donation_button_choice_background)
            }
            2->{
                donateButton.setTextColor(Color.parseColor("#FFFFFF"))
                donateButton.setBackgroundResource(R.drawable.donation_button_choice_background)
            }
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return spinnerList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return spinnerList.size
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemRowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.donation_spinner_dropdown, parent, false)
            vh = ItemRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemRowHolder
        }

        val params = view.layoutParams

        view.layoutParams = params

        vh.label.text = spinnerList.get(position)
        return view
    }
}
private class ItemRowHolder(row: View?) {

    val label: TextView

    init {
        this.label = row?.findViewById<View>(R.id.donation_spinner_text) as TextView
    }
}