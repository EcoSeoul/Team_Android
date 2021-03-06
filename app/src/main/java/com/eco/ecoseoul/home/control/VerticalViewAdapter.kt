package com.eco.ecoseoul.home.control

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.ViewGroup
import com.eco.ecoseoul.home.view.ChildFragment
import com.eco.ecoseoul.home.view.MainFragment

/**
 * Created by minhyoung on 2018. 9. 16..
 */
class VerticalViewAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        var frg : Fragment? = null
        when(position){
            0->{
                frg = ChildFragment()
            }
            1->{
                frg = MainFragment()
            }
        }
        return frg
    }

    override fun getCount(): Int {
        return 2
    }
}