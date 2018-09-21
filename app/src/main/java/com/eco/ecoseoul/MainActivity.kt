package com.eco.ecoseoul

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.eco.ecoseoul.home.control.VerticalViewAdapter

class MainActivity : AppCompatActivity() {

    var MAX_PAGE : Int = 3
    lateinit var verticalPage : ViewPager
    lateinit var verticalAdapter : VerticalViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalPage = this.findViewById(R.id.verticalViewPager)
        verticalAdapter = VerticalViewAdapter(supportFragmentManager)
        verticalPage.adapter = verticalAdapter

//        verticalPage.clipToPadding = false
//        verticalPage.setPadding(0,0,0,100)

        verticalPage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                when(position){
//                    0->{
//                        verticalPage.setPadding(0,0,0,100)
//                    }
//                    1->{
//                        verticalPage.setPadding(0,0,0,0)
//                    }
                }
            }

            override fun onPageSelected(position: Int) {

            }

        })



    }
}

