package com.eco.ecoseoul.donation.control

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.eco.ecoseoul.donation.view.DonationFragment
import com.eco.ecoseoul.home.view.HomeFragment
import com.eco.ecoseoul.home.view.UsageFragment

/**
 * Created by minhyoung on 2018. 9. 27..
 */
class DonationAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        var currentFragment : Fragment? = null

        var bundle = Bundle()
        bundle.putInt("donation",position)

        when(position){
            0 -> {
                currentFragment = DonationFragment()
            }

            1 -> {
                currentFragment = DonationFragment()

            }
            2 -> {
                currentFragment = DonationFragment()
            }
        }
        currentFragment!!.arguments = bundle
        return currentFragment

    }

    override fun getCount(): Int {
        return 3
    }
}