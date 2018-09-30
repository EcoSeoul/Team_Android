package com.eco.ecoseoul.mypage.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import android.support.v7.widget.Toolbar
import android.widget.ImageButton
import com.eco.ecoseoul.R
import com.eco.ecoseoul.mypage.control.TabViewPagerAdapter

class MypageMylistActivity : AppCompatActivity() {

    lateinit var toolbar : Toolbar
    lateinit var tablayout : TabLayout
    lateinit var viewpager : ViewPager
    lateinit var closeButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_mylist)

        toolbar = findViewById<View>(R.id.my_list_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        viewpager = findViewById<View>(R.id.my_list_vp) as ViewPager
        setupViewPager(viewpager)
        tablayout = findViewById<View>(R.id.my_list_tab) as TabLayout
        tablayout.setupWithViewPager(viewpager)

        closeButton = findViewById(R.id.my_list_back_btn)
        closeButton.setOnClickListener{
            finish()
        }
    }

    private fun setupViewPager(viewpager: ViewPager) {
        var adapter : TabViewPagerAdapter = TabViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MyList1Fragment(), "신청 내역")
        adapter.addFragment(MyList2Fragment(), "기부 내역")
        adapter.addFragment(MyList3Fragment(), "내가 쓴 글")
        viewpager.adapter = adapter
    }
}
