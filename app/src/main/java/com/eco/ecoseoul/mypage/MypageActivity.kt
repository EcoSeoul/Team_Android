package com.eco.ecoseoul.mypage

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.eco.ecoseoul.R
import kotlinx.android.synthetic.main.dialog_exchange.*
import kotlinx.android.synthetic.main.dialog_exchange.view.*

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

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MypageActivity>> ", "onCreate")
        super.onCreate(savedInstanceState)
        Log.d("MypageActivit>>", "after_onCreate")
        setContentView(R.layout.activity_mypage)

        var onClick = View.OnClickListener { v: View? ->

            var intent : Intent? = null
            when(v!!.id) {

                R.id.btn_my_emileage_detail -> { //에코 마일리지 상세보기
                    intent = Intent(this, MileageActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_my_emoney_detail -> { //에코 머니 상세보기
                    intent = Intent(this, MileageActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_my_exchange1 -> { //에코 마일리지 -> 에코머니 전환 다이얼로그 띄우기
                    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_exchange, null)
                    val builder = AlertDialog.Builder(this)
                            .setView(dialogView)

                    val alertDialog = builder.show()
                    alertDialog.btn_total_emileage.setOnClickListener {
                        //에코 마일리지 전액을 텍스트 뷰에
                    }
                    alertDialog.btn_exchange_emoney.setOnClickListener {
                        //onResume()
                    }
                }
                R.id.btn_my_exchange2 -> { //에코 마일리지 -> 에코머니 전환 다이얼로그 띄우기
                    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_exchange, null)
                    val builder = AlertDialog.Builder(this)
                            .setView(dialogView)

                    val alertDialog = builder.show()
                    alertDialog.btn_total_emileage.setOnClickListener {
                        //에코 마일리지 전액을 텍스트 뷰에
                    }
                    alertDialog.btn_exchange_emoney.setOnClickListener {
                        //onResume()
                    }
                }
                R.id.btn_my_request -> { //신청 내역 보기
                    /*intent = Intent(this, MyRequestActivity::class.java)
                    startActivity(intent)*/
                }
                R.id.btn_my_donation -> { //기부 내역 보기
                    /*intent = Intent(this, MyDonationActivity::class.java)
                    startActivity(intent)*/
                }
                R.id.btn_my_post -> { //내가 쓴 글 보기
                    /*intent = Intent(this, MyPostACtivity::class.java)
                    startActivity(intent)*/
                }
                R.id.btn_my_card -> { //카드 등록하기
                    /*intent = Intent(this, MyCardActivity::class.java)
                    startActivity(intent)*/
                }
                R.id.btn_my_faq1 -> { //자주 묻는 질문

                }
                R.id.btn_my_faq2 -> { //자주 묻는 질문

                }
                R.id.btn_my_logout -> { //로그아웃

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