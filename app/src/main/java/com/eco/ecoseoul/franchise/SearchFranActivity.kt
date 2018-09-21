package com.eco.ecoseoul.franchise

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.eco.ecoseoul.MapsActivity
import com.eco.ecoseoul.R
import kotlinx.android.synthetic.main.activity_searchfran.*

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchfran)

        var onClick = View.OnClickListener { v: View? ->

            var intent = Intent(this, MapsActivity::class.java)
            var areaCode = 0
            when (v!!.id) {
                R.id.btn_dongdaemoon -> {
                    areaCode = 0
                }
                R.id.btn_dongjak -> {
                    areaCode = 0
                }
                R.id.btn_eunpyeong -> {
                    areaCode = 0
                }
                R.id.btn_geumchun -> {
                    areaCode = 0
                }
                R.id.btn_gwangjin -> {
                    areaCode = 0
                }
                R.id.btn_jongro -> {
                    areaCode = 0
                }
                R.id.btn_joonggoo -> {
                    areaCode = 0
                }
                R.id.btn_joongrang -> {
                    areaCode = 0
                }
                R.id.btn_kangbook -> {
                    areaCode = 0
                }
                R.id.btn_kangdong -> {
                    areaCode = 0
                }
                R.id.btn_kangnam -> {
                    areaCode = 0
                }
                R.id.btn_kangseo -> {
                    areaCode = 0
                }
                R.id.btn_mapo -> {
                    areaCode = 0
                }
                R.id.btn_no_one -> {
                    areaCode = 0
                }
                R.id.btn_seocho -> {
                    areaCode = 0
                }
                R.id.btn_seongbook -> {
                    areaCode = 0
                }
                R.id.btn_seongdong -> {
                    areaCode = 0
                }
                R.id.btn_songpa -> {
                    areaCode = 0
                }
                R.id.btn_yangcheon -> {
                    areaCode = 0
                }
                R.id.btn_yeongdeungpo -> {
                    areaCode = 0
                }
            }

            intent.putExtra("areaCode", areaCode)
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