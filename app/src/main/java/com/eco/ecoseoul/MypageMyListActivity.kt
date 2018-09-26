package com.eco.ecoseoul

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Toolbar

class MypageMyListActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var tablayout: TabLayout
    lateinit var viewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_my_list)
        toolbar = findViewById<View>(R.id.my_list_toolbar) as Toolbar
    }
}
