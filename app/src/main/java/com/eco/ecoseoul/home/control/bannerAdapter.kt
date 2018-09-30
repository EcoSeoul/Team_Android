package com.eco.ecoseoul.home.control

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.eco.ecoseoul.MainBanner1Activity
import com.eco.ecoseoul.MainBanner2Activity
import com.eco.ecoseoul.MainBanner3Activity
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.view.AllActivity

/**
 * Created by minhyoung on 2018. 9. 19..
 */
class bannerAdapter(context: Context) : PagerAdapter(){

    var images : Array<Int> = arrayOf(R.drawable.main_banner,R.drawable.main_banner2, R.drawable.main_banner3)
    var context = context
    lateinit var inflater : LayoutInflater
    lateinit var bannerImage : ImageView

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var view = inflater.inflate(R.layout.banner_main,container,false)
        bannerImage = view.findViewById(R.id.main_banner_image)

        bannerImage.setImageResource(images[position])
        bannerImage.setOnClickListener{


            when(position){
                0->{
//                    val intent = Intent(, MainBanner1Activity::class.java)
//                    (context as Activity).startActivity(intent)

                    context.startActivity(Intent(context,MainBanner1Activity::class.java))
                }
                1->{
                    context.startActivity(Intent(context,MainBanner2Activity::class.java))
                }
                2->{
                    context.startActivity(Intent(context, MainBanner3Activity::class.java))
                }
            }
        }
        container!!.addView(view)
        return view
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object` as LinearLayout
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as View)
    }
}