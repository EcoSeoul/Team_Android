package com.eco.ecoseoul.mypage.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TabHost
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.SharedPreference
import kotlinx.android.synthetic.main.activity_mileage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.graphics.Color
import android.widget.TextView
import com.eco.ecoseoul.mypage.control.MileageAdapter
import com.eco.ecoseoul.mypage.model.MileageResponse


class MileageActivity : AppCompatActivity() {

    lateinit var networkService: NetworkService
    lateinit var tabHost : TabHost

    lateinit var closeButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mileage)

        var user_idx = SharedPreference.instance!!.getPrefIntegerData("user_idx")
        var eco_value = intent.getIntExtra("flag",0)
        var user_mileage = intent.getIntExtra("user_mileage",0)
        var user_money = intent.getIntExtra("user_money",0)
        Log.d("user_idx",user_idx.toString())
        Log.d("user_idx",eco_value.toString())
        tabHost = findViewById(R.id.mileage_tab)
        networkService = ApplicationController.instance.networkService

        closeButton = findViewById(R.id.mypage_close)
        closeButton.setOnClickListener{
            finish()
        }


        val usedResponse = networkService.getUsages(user_idx,0)
        usedResponse.enqueue(object : Callback<MileageResponse>{
            override fun onFailure(call: Call<MileageResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<MileageResponse>?, response: Response<MileageResponse>?) {
                if (response!!.isSuccessful){
                    var mileResponse = response

                    val anotherResponse = networkService.getUsages(user_idx,0)
                    anotherResponse.enqueue(object : Callback<MileageResponse>{
                        override fun onFailure(call: Call<MileageResponse>?, t: Throwable?) {

                        }

                        override fun onResponse(call: Call<MileageResponse>?, response2: Response<MileageResponse>?) {
                            if(response!!.isSuccessful){
                                var moneyResponse = response2

                                var mileList = mileResponse!!.body()!!.mileage_total_usage
                                var moneyList = moneyResponse!!.body()!!.mileage_total_usage

                                tabHost.setup()

                                tv_emileage.text = user_mileage.toString()
                                tv_emileage_save.text = mileResponse!!.body()!!.saved_mileage.toString()
                                tv_emileage_use.text = mileResponse!!.body()!!.used_mileage.toString()

                                tv_emoney.text = user_money.toString()
                                tv_emoney_use.text = moneyResponse!!.body()!!.used_mileage.toString()
                                tv_emoney_save.text = moneyResponse!!.body()!!.saved_mileage.toString()

                                rv_emileage.layoutManager = LinearLayoutManager(this@MileageActivity, LinearLayout.VERTICAL, false)
                                rv_emoney.layoutManager = LinearLayoutManager(this@MileageActivity, LinearLayout.VERTICAL, false)
                                rv_emileage.setHasFixedSize(true)
                                rv_emoney.setHasFixedSize(true)

                                rv_emileage.adapter = MileageAdapter(mileList)
                                rv_emoney.adapter = MileageAdapter(moneyList)
                                tabHost.addTab(tabHost.newTabSpec("").setContent(R.id.fl_emileage).setIndicator("에코 마일리지"))
                                tabHost.addTab(tabHost.newTabSpec("").setContent(R.id.fl_emoney).setIndicator("에코 머니"))

                                //tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#FDD030"))
                                val tv1 = tabHost.getTabWidget().getChildAt(0).findViewById<View>(android.R.id.title) as TextView
                                tv1.setTextColor(Color.parseColor("#707070"))
                                tv1.textSize = 17f

                                val tv2 = tabHost.getTabWidget().getChildAt(1).findViewById<View>(android.R.id.title) as TextView
                                tv2.setTextColor(Color.parseColor("#707070"))
                                tv2.textSize = 17f

                                if(eco_value == 0){
                                    tabHost.currentTab = 0
                                } else {
                                    tabHost.currentTab = 1
                                }


                            }
                        }

                    })
                } else {

                }
            }

        })


//       val mileageResponse = networkService.getUsages(user_idx, eco_value)
//        mileageResponse.enqueue(object : Callback<MileageResponse>{
//            override fun onFailure(call: Call<MileageResponse>, t: Throwable) {
//                Log.d("getUsage ",  "fail")
//            }
//
//            override fun onResponse(call: Call<MileageResponse>, response: Response<MileageResponse>) {
//                Log.d ("getUsage", "success")
//                tabHost.setup()
//
//                if(response!!.isSuccessful){
//
//                    if(eco_value == 0){
//                        var emileageList = response!!.body()!!.mileage_total_usage
//                        val moneyResponse = networkService.getUsages(user_idx,1)
//                        tv_emileage.text = user_mileage.toString()
//                        tv_emileage_use.text = response!!.body()!!.used_mileage.toString()
//                        //tv_emileage_save.text
//                        moneyResponse.enqueue(object : Callback<MileageResponse>{
//                            override fun onFailure(call: Call<MileageResponse>?, t: Throwable?) {
//
//                            }
//
//                            override fun onResponse(call: Call<MileageResponse>?, response: Response<MileageResponse>?) {
//                                if(response!!.isSuccessful){
//                                    var  emoneyList = response!!.body()!!.mileage_total_usage
//                                    Log.d("asdfasdfasdf",emoneyList.size.toString())
//
//                                    tv_emoney.text = user_money.toString()
//                                    //tv_emoney_save.text
//                                    tv_emoney_use.text = response!!.body()!!.used_mileage.toString()
//
//                                    rv_emileage.layoutManager = LinearLayoutManager(this@MileageActivity, LinearLayout.VERTICAL, false)
//                                    rv_emoney.layoutManager = LinearLayoutManager(this@MileageActivity, LinearLayout.VERTICAL, false)
//                                    rv_emileage.setHasFixedSize(true)
//                                    rv_emoney.setHasFixedSize(true)
//
//                                    rv_emileage.adapter = MileageAdapter(emileageList)
//                                    rv_emoney.adapter = MileageAdapter(emoneyList)
//                                    tabHost.addTab(tabHost.newTabSpec("").setContent(R.id.fl_emileage).setIndicator("에코 마일리지"))
//                                    tabHost.addTab(tabHost.newTabSpec("").setContent(R.id.fl_emoney).setIndicator("에코 머니"))
//                                    tabHost.currentTab = 0
//                                }
//                            }
//
//                        })
//                    } else {
//                        var emoneyList = response!!.body()!!.mileage_total_usage
//                        val moneyResponse = networkService.getUsages(user_idx,0)
//
//                        tv_emoney.text = user_money.toString()
//                        //tv_emoney_save.text
//                        tv_emoney_use.text = response!!.body()!!.used_mileage.toString()
//                        moneyResponse.enqueue(object : Callback<MileageResponse>{
//                            override fun onFailure(call: Call<MileageResponse>?, t: Throwable?) {
//
//                            }
//
//                            override fun onResponse(call: Call<MileageResponse>?, response: Response<MileageResponse>?) {
//                              if(response!!.isSuccessful){
//                                  var emileageList = response!!.body()!!.mileage_total_usage
//
//
//
//                                  tv_emileage.text = user_mileage.toString()
//                                  tv_emileage_use.text = response!!.body()!!.used_mileage.toString()
//                                  //tv_emileage_save.text
//
//
//                                  rv_emileage.layoutManager = LinearLayoutManager(this@MileageActivity, LinearLayout.VERTICAL, false)
//                                  rv_emoney.layoutManager = LinearLayoutManager(this@MileageActivity, LinearLayout.VERTICAL, false)
//                                  rv_emileage.setHasFixedSize(true)
//                                  rv_emoney.setHasFixedSize(true)
//
//                                  rv_emileage.adapter = MileageAdapter(emileageList)
//                                  rv_emoney.adapter = MileageAdapter(emoneyList)
//                                  tabHost.addTab(tabHost.newTabSpec("").setContent(R.id.fl_emileage).setIndicator("에코 마일리지"))
//                                  tabHost.addTab(tabHost.newTabSpec("").setContent(R.id.fl_emoney).setIndicator("에코 머니"))
//                                  tabHost.currentTab = 1
//                              }
//                            }
//
//                        })
//                    }
//                }
//
//            }
//        })


    }
}