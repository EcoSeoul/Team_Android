package com.eco.ecoseoul.mypage

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.mypage.MileageAdapter
import kotlinx.android.synthetic.main.activity_mileage.*
import kotlinx.android.synthetic.main.activity_mypage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class Mileage (/*val mileage_image: String, */val mileage_content: String, val mileage_date: String, val mileage_count: String)

class MileageActivity : AppCompatActivity() {

    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_mileage)

        networkService = ApplicationController.instance.networkService

       /* val mileageResponse = networkService.getUsages(0, 0)
        mileageResponse.enqueue(object : Callback<MileageResponse>{
            override fun onFailure(call: Call<MileageResponse>, t: Throwable) {
                Log.d("getUsage ",  "fail")
            }

            override fun onResponse(call: Call<MileageResponse>, response: Response<MileageResponse>) {
                Log.d ("getUsage", "success")
            }
        })*/
        val emileageList = arrayListOf<Mileage> (
                /*Mileage("", "10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("", "10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("", "10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("", "T-money 구매", "2018.08.22", "-20000"),
                Mileage("", "T-money 구매", "2018.08.22", "-20000"),
                Mileage("", "T-money 구매", "2018.08.22", "-20000"),
                Mileage("", "10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("", "10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("", "10% 달성 적립", "2018.08.22", "+20000")*/
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("T-money 구매", "2018.08.22", "-20000"),
                Mileage("T-money 구매", "2018.08.22", "-20000"),
                Mileage("T-money 구매", "2018.08.22", "-20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000")
        )

        val emoneyList = arrayListOf<Mileage> (
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("T-money 구매", "2018.08.22", "-20000"),
                Mileage("T-money 구매", "2018.08.22", "-20000"),
                Mileage("T-money 구매", "2018.08.22", "-20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000"),
                Mileage("10% 달성 적립", "2018.08.22", "+20000")
        )

        rv_emileage.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_emoney.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_emileage.setHasFixedSize(true)
        rv_emoney.setHasFixedSize(true)

        rv_emileage.adapter = MileageAdapter(emileageList)
        rv_emoney.adapter = MileageAdapter(emoneyList)
    }
}
