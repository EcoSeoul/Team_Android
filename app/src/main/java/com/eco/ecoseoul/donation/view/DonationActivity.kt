package com.eco.ecoseoul.donation.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.ImageView
import com.eco.ecoseoul.R
import com.eco.ecoseoul.donation.control.DonationAdapter
import com.eco.ecoseoul.mypage.view.MypageActivity
import me.relex.circleindicator.CircleIndicator

class DonationActivity : AppCompatActivity() {

    lateinit var donationViewPager : ViewPager
    lateinit var donationAdapter: DonationAdapter
    lateinit var donationIndicator : CircleIndicator

    lateinit var mypageButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation)

        donationViewPager = findViewById(R.id.donation_viewpager)
        mypageButton = findViewById(R.id.donation_mypage_button)
        mypageButton.setOnClickListener {
            var intent = Intent(this@DonationActivity, MypageActivity::class.java)
            startActivity(intent)
        }
        donationAdapter = DonationAdapter(supportFragmentManager)
        donationViewPager.adapter = donationAdapter
        donationViewPager.currentItem = 0

        donationIndicator = findViewById(R.id.donation_indicator)
        donationIndicator.setViewPager(donationViewPager)
    }
}
