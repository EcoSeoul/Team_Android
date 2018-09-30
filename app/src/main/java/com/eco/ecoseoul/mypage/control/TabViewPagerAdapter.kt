package com.eco.ecoseoul.mypage.control

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabViewPagerAdapter : FragmentPagerAdapter {

    private val FragmentList : MutableList<Fragment> = mutableListOf()
    private val FragmentTitleList : MutableList<String> = mutableListOf()


    constructor(manager : FragmentManager) : super (manager) {

    }

    fun addFragment(fragment: Fragment, title : String) {
        FragmentList.add(fragment)
        FragmentTitleList.add(title)
    }


    override fun getItem(position: Int): Fragment {
        return FragmentList.get(position)
    }

    override fun getCount(): Int {
        return FragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {

        return FragmentTitleList.get(position)
    }
}