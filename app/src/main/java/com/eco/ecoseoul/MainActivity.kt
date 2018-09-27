package com.eco.ecoseoul

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.eco.ecoseoul.home.control.VerticalViewAdapter
import android.util.TypedValue
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.home.model.MainResponse
import com.eco.ecoseoul.home.view.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var verticalPage : ViewPager
    lateinit var verticalAdapter : VerticalViewAdapter
    lateinit var networkService : NetworkService
    var mainData : Response<MainResponse>? = null

    companion object {
        lateinit var mContext: Context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("asdf","mainActivity")
        mContext = this

        networkService = ApplicationController!!.instance.networkService

        verticalPage = findViewById(R.id.verticalViewPager)
        verticalAdapter = VerticalViewAdapter(supportFragmentManager)
        verticalPage.adapter = verticalAdapter

        verticalPage.clipToPadding = false
        verticalPage.offscreenPageLimit = 1

        verticalPage.setPadding(0,0,0,convertDip2Pixels(this,51))

        verticalPage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0->{
                        verticalPage.setPadding(0,0,0,convertDip2Pixels(this@MainActivity,51))
                        Log.d("main","position 0")

                    }
                    1->{
                        verticalPage.setPadding(0,0,0,0)
                        Log.d("main","position 1")
                    }
                }
            }

        })

       //getMainItems()

    }

    fun getMainItems(){
        val mainResponse = networkService.getMainItems(1)
        mainResponse.enqueue(object : Callback<MainResponse>{
            override fun onFailure(call: Call<MainResponse>?, t: Throwable?) {
                Log.d("Network","main Failure")
            }

            override fun onResponse(call: Call<MainResponse>?, response: Response<MainResponse>?) {
                if(response!!.isSuccessful){
                    Log.d("Network",response!!.body()!!.message)
                    Log.d("Network",""+response!!.body()!!.term[0])
                    Log.d("Network",""+response!!.body()!!.carbon[0])
                    Log.d("Network",""+response!!.body()!!.totalCarbon)
                    Log.d("Network",""+response!!.body()!!.usageData.carbon.percentage)
                    Log.d("Network",""+response!!.body()!!.userInfo[0].user_barcodenum)
                    Log.d("Network",""+response!!.body()!!.userInfo[0].user_mileage)

                    mainData = response
                } else {
                    Log.d("Network","main Client Error")
                }
            }

        })
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","onStop")
    }

    fun getData() : Response<MainResponse>?{
        return LoginActivity.mainData
    }

    fun changePage(){
        verticalPage.setCurrentItem(1,true)
    }


    fun convertDip2Pixels(context: Context, dip: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip.toFloat(), context.getResources().getDisplayMetrics()).toInt()
    }
}

