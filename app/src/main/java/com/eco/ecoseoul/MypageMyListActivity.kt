package com.eco.ecoseoul

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.support.v7.widget.Toolbar
import android.widget.LinearLayout

class MypageMyListActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var tablayout: TabLayout
    lateinit var viewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_my_list)
        toolbar = findViewById<View>(R.id.my_list_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        viewPager = findViewById<View>(R.id.my_list_vp) as ViewPager
        setupViewPager (viewPager)
        tablayout = findViewById<View>(R.id.my_list_tab) as TabLayout
        tablayout.setupWithViewPager(viewPager)

        val recyclerView = findViewById<View>(R.id.request_list) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val rq = ArrayList<RequestItem>()

        rq.add(RequestItem("티머니 충전권", "2018.08.26"))
        rq.add(RequestItem("최고급 텀블러", "2018.08.26"))
        rq.add(RequestItem("이민형 멋잠", "2018.08.26"))

        val adapter = RequestAdapter(rq)
        recyclerView.adapter = adapter

    }

    private fun setupViewPager(viewPager: ViewPager) {
        var adapter : ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MyList1Fragment(), "신청 내역")
        adapter.addFragment(MyList1Fragment(), "기부 내역")
        adapter.addFragment(MyList1Fragment(), "내가 쓴 글")

        viewPager.adapter = adapter
    }

}
