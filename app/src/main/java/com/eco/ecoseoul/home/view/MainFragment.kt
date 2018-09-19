package com.eco.ecoseoul.home.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.control.bannerAdapter

/**
 * Created by minhyoung on 2018. 9. 18..
 */
class MainFragment : Fragment() {

    lateinit var bannerPager : ViewPager
    lateinit var bannerAdapter: bannerAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_main,container,false)

        initBanner(view)

        return view
    }

    fun initBanner(view : View){
        bannerAdapter = bannerAdapter(activity.applicationContext)
        bannerPager = view.findViewById(R.id.main_banner_pager)

        bannerPager.adapter = bannerAdapter
        bannerPager.invalidate()
    }
}