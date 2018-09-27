package com.eco.ecoseoul.mypage

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.eco.ecoseoul.R

class MypageActivity : AppCompatActivity() {
    lateinit var btn_my_emileage_detail : Button
    lateinit var btn_my_emoney_detail : Button
    lateinit var btn_my_exchange1 : Button
    lateinit var btn_my_exchange2 : Button
    lateinit var btn_my_request : Button
    lateinit var btn_my_donation : Button
    lateinit var btn_my_post : Button
    lateinit var btn_my_card : Button
    lateinit var btn_my_faq1 : Button
    lateinit var btn_my_faq2 : Button
    lateinit var btn_my_logout : Button

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_mypage)

        var onClick = View.OnClickListener { v: View? ->

            when(v!!.id) {

                R.id.btn_my_emileage_detail -> {

                }
                R.id.btn_my_emoney_detail -> {

                }
                R.id.btn_my_exchange1 -> {

                }
                R.id.btn_my_exchange2 -> {

                }
                R.id.btn_my_request -> {

                }
                R.id.btn_my_donation -> {

                }
                R.id.btn_my_post -> {

                }
                R.id.btn_my_card -> {

                }
                R.id.btn_my_faq1 -> {

                }
                R.id.btn_my_faq2 -> {

                }
                R.id.btn_my_logout -> {

                }
            }
        }

        btn_my_emileage_detail = findViewById(R.id.btn_my_emileage_detail)
        btn_my_emileage_detail.setOnClickListener(onClick)
        btn_my_emoney_detail = findViewById(R.id.btn_my_emoney_detail)
        btn_my_emoney_detail.setOnClickListener(onClick)
        btn_my_exchange1 = findViewById(R.id.btn_my_exchange1)
        btn_my_exchange1.setOnClickListener(onClick)
        btn_my_exchange2 = findViewById(R.id.btn_my_exchange2)
        btn_my_exchange2.setOnClickListener(onClick)
        btn_my_request = findViewById(R.id.btn_my_request)
        btn_my_request.setOnClickListener(onClick)
        btn_my_donation = findViewById(R.id.btn_my_donation)
        btn_my_donation.setOnClickListener(onClick)
        btn_my_post = findViewById(R.id.btn_my_post)
        btn_my_post.setOnClickListener(onClick)
        btn_my_card = findViewById(R.id.btn_my_card)
        btn_my_card.setOnClickListener(onClick)
        btn_my_faq1 = findViewById(R.id.btn_my_faq1)
        btn_my_faq1.setOnClickListener(onClick)
        btn_my_faq2 = findViewById(R.id.btn_my_faq2)
        btn_my_faq2.setOnClickListener(onClick)
        btn_my_logout = findViewById(R.id.btn_my_logout)
        btn_my_logout.setOnClickListener(onClick)
    }

}