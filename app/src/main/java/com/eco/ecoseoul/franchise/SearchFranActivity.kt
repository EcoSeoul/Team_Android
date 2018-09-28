package com.eco.ecoseoul.franchise

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.MapsActivity
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import kotlinx.android.synthetic.main.activity_searchfran.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFranActivity: AppCompatActivity() {

    lateinit var btn_dongdaemoon: Button
    lateinit var btn_dongjak: Button
    lateinit var btn_eunpyeong: Button
    lateinit var btn_geumchun: Button
    lateinit var btn_gwangjin: Button
    lateinit var btn_jongro: Button
    lateinit var btn_joonggoo: Button
    lateinit var btn_joongrang: Button
    lateinit var btn_kangbook: Button
    lateinit var btn_kangdong: Button
    lateinit var btn_kangnam: Button
    lateinit var btn_kangseo: Button
    lateinit var btn_mapo: Button
    lateinit var btn_no_one: Button
    lateinit var btn_seocho: Button
    lateinit var btn_seongbook: Button
    lateinit var btn_seongdong: Button
    lateinit var btn_songpa: Button
    lateinit var btn_yangcheon: Button
    lateinit var btn_yeongdeungpo: Button

    lateinit var networkService : NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchfran)

        networkService = ApplicationController.instance.networkService

        var onClick = View.OnClickListener { v: View? ->

            var intent = Intent(this, MapsActivity::class.java)
            var gu_idx = 0
            var franchiseResponse = networkService.getFranchises(gu_idx)
            when (v!!.id) {
                R.id.btn_dongdaemoon -> {
                    gu_idx = 5
                }
                R.id.btn_dongjak -> {
                    gu_idx = 16
                }
                R.id.btn_eunpyeong -> {
                    gu_idx = 21
                }
                R.id.btn_geumchun -> {
                    gu_idx = 17
                }
                R.id.btn_gwangjin -> {
                    gu_idx = 8
                }
                R.id.btn_jongro -> {
                    gu_idx = 13
                }
                R.id.btn_joonggoo -> {
                    gu_idx = 14
                }
                R.id.btn_joongrang -> {
                    gu_idx = 6
                }
                R.id.btn_kangbook -> {
                    gu_idx = 1
                }
                R.id.btn_kangdong -> {
                    gu_idx = 9
                }
                R.id.btn_kangnam -> {
                    gu_idx = 12
                }
                R.id.btn_kangseo -> {
                    gu_idx = 18
                }
                R.id.btn_mapo -> {
                    gu_idx = 22
                }
                R.id.btn_no_one -> {
                    gu_idx = 4
                }
                R.id.btn_seocho -> {
                    gu_idx = 11
                }
                R.id.btn_seongbook -> {
                    gu_idx = 3
                }
                R.id.btn_seongdong -> {
                    gu_idx = 7
                }
                R.id.btn_songpa -> {
                    gu_idx = 10
                }
                R.id.btn_yangcheon -> {
                    gu_idx = 19
                }
                R.id.btn_yeongdeungpo -> {
                    gu_idx = 20
                }
            }

//            franchiseResponse.enqueue(object : Callback<FranchiseResponse>{
//                override fun onFailure(call: Call<FranchiseResponse>, t: Throwable) {
//                    Log.d("getFranchise: ", "fail")
//                }
//
//                override fun onResponse(call: Call<FranchiseResponse>, response: Response<FranchiseResponse>) {
//                    if (response!!.isSuccessful) {
//                        Log.d("getFranchise:", "success")
//                        for (i in 0 ..(response!!.body()!!.data.size - 1))
//                            Log.d("getFranchise: ", response!!.body()!!.data[i].gu_idx.toString())
//                        intent.putExtra("gu_idx", gu_idx)
//                        startActivity(intent)
//                    }
//                }
//
//            })
            intent.putExtra("gu_idx", gu_idx)
            startActivity(intent)


        }

        btn_dongdaemoon = findViewById(R.id.btn_dongdaemoon)
        btn_dongdaemoon.setOnClickListener(onClick)
        btn_dongjak = findViewById(R.id.btn_dongjak)
        btn_dongjak.setOnClickListener(onClick)
        btn_eunpyeong = findViewById(R.id.btn_eunpyeong)
        btn_eunpyeong.setOnClickListener(onClick)
        btn_geumchun = findViewById(R.id.btn_geumchun)
        btn_geumchun.setOnClickListener(onClick)
        btn_gwangjin = findViewById(R.id.btn_gwangjin)
        btn_gwangjin.setOnClickListener(onClick)
        btn_jongro = findViewById(R.id.btn_jongro)
        btn_jongro.setOnClickListener(onClick)
        btn_joonggoo = findViewById(R.id.btn_joonggoo)
        btn_joonggoo.setOnClickListener(onClick)
        btn_joongrang = findViewById(R.id.btn_joongrang)
        btn_joongrang.setOnClickListener(onClick)
        btn_kangbook = findViewById(R.id.btn_kangbook)
        btn_kangbook.setOnClickListener(onClick)
        btn_kangdong = findViewById(R.id.btn_kangdong)
        btn_kangdong.setOnClickListener(onClick)
        btn_kangnam = findViewById(R.id.btn_kangnam)
        btn_kangnam.setOnClickListener(onClick)
        btn_kangseo = findViewById(R.id.btn_kangseo)
        btn_kangseo.setOnClickListener(onClick)
        btn_mapo = findViewById(R.id.btn_mapo)
        btn_mapo.setOnClickListener(onClick)
        btn_no_one = findViewById(R.id.btn_no_one)
        btn_no_one.setOnClickListener(onClick)
        btn_seocho = findViewById(R.id.btn_seocho)
        btn_seocho.setOnClickListener(onClick)
        btn_seongbook = findViewById(R.id.btn_seongbook)
        btn_seongbook.setOnClickListener(onClick)
        btn_seongdong = findViewById(R.id.btn_seongdong)
        btn_seongdong.setOnClickListener(onClick)
        btn_songpa = findViewById(R.id.btn_songpa)
        btn_songpa.setOnClickListener(onClick)
        btn_yangcheon = findViewById(R.id.btn_yangcheon)
        btn_yangcheon.setOnClickListener(onClick)
        btn_yeongdeungpo = findViewById(R.id.btn_yeongdeungpo)
        btn_yeongdeungpo.setOnClickListener(onClick)


    }
}