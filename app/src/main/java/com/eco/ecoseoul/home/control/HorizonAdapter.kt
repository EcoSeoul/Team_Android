package com.eco.ecoseoul.home.control

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.eco.ecoseoul.home.view.HomeFragment
import com.eco.ecoseoul.home.view.UsageFragment

/**
 * Created by minhyoung on 2018. 9. 13..
 */
class HorizonAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        var currentFragment : Fragment? = null

        var bundle = Bundle()
        bundle.putInt("usage",position)

        when(position){
            0 -> {
                currentFragment = HomeFragment()
            }

            1 -> {
                currentFragment = UsageFragment()

            }
            2 -> {
                currentFragment = UsageFragment()
            }
            3 -> {
                currentFragment = UsageFragment()
            }
        }
        currentFragment!!.arguments = bundle
        return currentFragment
    }

    override fun getCount(): Int {
        return 4
    }
}