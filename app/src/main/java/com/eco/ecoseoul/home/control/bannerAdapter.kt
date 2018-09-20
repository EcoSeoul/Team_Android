package com.eco.ecoseoul.home.control

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.eco.ecoseoul.R

/**
 * Created by minhyoung on 2018. 9. 19..
 */
class bannerAdapter(context: Context) : PagerAdapter(){

    var images : Array<Int> = arrayOf(R.drawable.main_banner)
    var context = context
    lateinit var inflater : LayoutInflater
    lateinit var bannerImage : ImageView
    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var view = inflater.inflate(R.layout.banner_main,container,false)
        bannerImage = view.findViewById(R.id.main_banner_image)

        bannerImage.setImageResource(images[position])
        container!!.addView(view)
        return view
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object` as LinearLayout
    }

    override fun getCount(): Int {
        return images.size
    }
}