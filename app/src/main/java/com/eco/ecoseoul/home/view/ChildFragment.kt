package com.eco.ecoseoul.home.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eco.ecoseoul.home.control.HorizonAdapter
import com.eco.ecoseoul.home.control.HorizontalViewPager
import com.eco.ecoseoul.R
import me.relex.circleindicator.CircleIndicator

/**
 * Created by minhyoung on 2018. 9. 13..
 */


class ChildFragment : Fragment() {

    lateinit var horViewpage : com.eco.ecoseoul.home.control.HorizontalViewPager
    lateinit var horizontalAdapter : HorizonAdapter
    lateinit var indicator : CircleIndicator

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_child,container,false)
        horViewpage = view.findViewById(R.id.horizon_view)
        horizontalAdapter = HorizonAdapter(childFragmentManager)
        horViewpage.adapter = horizontalAdapter
        horViewpage.currentItem = 0

        horViewpage.offscreenPageLimit = 0


        indicator = view.findViewById(R.id.main_indicator)
        indicator.setViewPager(horViewpage)
        return view
    }
}