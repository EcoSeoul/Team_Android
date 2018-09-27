package com.eco.ecoseoul.donation.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.eco.ecoseoul.R
import com.eco.ecoseoul.donation.control.DonationAdapter
import me.relex.circleindicator.CircleIndicator

class DonationActivity : AppCompatActivity() {

    lateinit var donationViewPager : ViewPager
    lateinit var donationAdapter: DonationAdapter
    lateinit var donationIndicator : CircleIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation)

        donationViewPager = findViewById(R.id.donation_viewpager)
        donationAdapter = DonationAdapter(supportFragmentManager)
        donationViewPager.adapter = donationAdapter
        donationViewPager.currentItem = 0

        donationIndicator = findViewById(R.id.donation_indicator)
        donationIndicator.setViewPager(donationViewPager)
    }
}
