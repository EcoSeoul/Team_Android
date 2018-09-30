package com.eco.ecoseoul.mypage.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.BaseModel
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.SharedPreference
import com.eco.ecoseoul.home.view.LoginActivity
import com.eco.ecoseoul.mypage.model.MypageResponse
import kotlinx.android.synthetic.main.dialog_exchange.*
import kotlinx.android.synthetic.main.dialog_exchange.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    lateinit var text_my_emileage : TextView
    lateinit var text_my_emoney : TextView

    lateinit var networkService: NetworkService

    var user_mileage = 0

    var user_money = 0
    var alertDialog : AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MypageActivity>> ", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        networkService = ApplicationController.instance!!.networkService

        getMypage()

        Log.d("MypageActivit>>", "after_onCreate")
        var onClick = View.OnClickListener { v: View? ->

            var intent : Intent? = null
            when(v!!.id) {
                R.id.mypage_close -> {
                    finish()
                }
                R.id.btn_my_emileage_detail -> { //에코 마일리지 상세보기
                    intent = Intent(this, MileageActivity::class.java)
                    intent.putExtra("flag",0)
                    intent.putExtra("user_mileage",user_mileage)
                    intent.putExtra("user_money",user_money)
                    startActivity(intent)
                }
                R.id.btn_my_emoney_detail -> { //에코 머니 상세보기
                    intent = Intent(this, MileageActivity::class.java)
                    intent.putExtra("flag",1)
                    intent.putExtra("user_mileage",user_mileage)
                    intent.putExtra("user_money",user_money)
                    startActivity(intent)
                }
                R.id.btn_my_exchange1 -> { //에코 마일리지 -> 에코머니 전환 다이얼로그 띄우기
                    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_exchange, null)
                    val builder = AlertDialog.Builder(this)
                            .setView(dialogView)
                    dialogView!!.text_user_name.text = SharedPreference.instance!!.getPrefStringData("user_name")
                    dialogView!!.text_user_mileage.text = user_mileage.toString()
                    dialogView!!.feedback_X_Btn.setOnClickListener {
                        alertDialog!!.dismiss()
                    }
                    alertDialog = builder.show()
                    alertDialog!!.btn_total_emileage.setOnClickListener {
                        //에코 마일리지 전액을 텍스트 뷰에
                        dialogView!!.edit_exchange_emileage.setText(user_mileage.toString())
                    }
                    alertDialog!!.btn_exchange_emoney.setOnClickListener {
                        //onResume()
                        var exchange = dialogView!!.edit_exchange_emileage.text.toString().toInt()
                        if(exchange < 1000){
                            Toast.makeText(this@MypageActivity,"1천 이상 입력해주세요",Toast.LENGTH_LONG).show()
                        } else if(exchange > user_mileage){
                            Toast.makeText(this@MypageActivity,"보유 마일리지가 모자랍니다",Toast.LENGTH_LONG).show()
                        } else if(user_mileage < 20000){
                            Toast.makeText(this@MypageActivity,"보유 마일리지가 2만 이상이여야 합니다",Toast.LENGTH_LONG).show()
                        } else {
                            exchangeMileage(exchange)
                        }
                    }
                }
                R.id.btn_my_exchange2 -> { //에코 마일리지 -> 에코머니 전환 다이얼로그 띄우기
                    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_exchange, null)
                    val builder = AlertDialog.Builder(this)
                            .setView(dialogView)
                    dialogView!!.text_user_name.text = SharedPreference.instance!!.getPrefStringData("user_name")
                    dialogView!!.text_user_mileage.text = user_mileage.toString()
                    dialogView!!.feedback_X_Btn.setOnClickListener {
                        alertDialog!!.dismiss()
                    }
                    alertDialog = builder.show()
                    alertDialog!!.btn_total_emileage.setOnClickListener {
                        //에코 마일리지 전액을 텍스트 뷰에
                        dialogView!!.edit_exchange_emileage.setText(user_mileage.toString())
                    }
                    alertDialog!!.btn_exchange_emoney.setOnClickListener {
                        //onResume()
                        var exchange = dialogView!!.edit_exchange_emileage.text.toString().toInt()
                        if(exchange < 1000){
                            Toast.makeText(this@MypageActivity,"1천 이상 입력해주세요",Toast.LENGTH_LONG).show()
                        } else if(exchange > user_mileage){
                            Toast.makeText(this@MypageActivity,"보유 마일리지가 모자랍니다",Toast.LENGTH_LONG).show()
                        } else if(user_mileage < 20000){
                            Toast.makeText(this@MypageActivity,"보유 마일리지가 2만 이상이여야 합니다",Toast.LENGTH_LONG).show()
                        } else {
                            exchangeMileage(exchange)
                        }
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
                    var intent = Intent(this@MypageActivity,LoginActivity::class.java)
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

        text_my_emileage = findViewById(R.id.tv_my_emileage)
        text_my_emoney = findViewById(R.id.tv_my_emoney)
    }

    fun getMypage(){
        val user_idx = SharedPreference!!.instance!!.getPrefIntegerData("user_idx")
        val myPageResponse = networkService.getMyData(user_idx)
        myPageResponse.enqueue(object : Callback<MypageResponse>{
            override fun onFailure(call: Call<MypageResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<MypageResponse>?, response: Response<MypageResponse>?) {
                if(response!!.isSuccessful){
                    text_my_emileage.text = response!!.body()!!.result[0].user_mileage.toString()
                    text_my_emoney.text = response!!.body()!!.result[0].user_money.toString()

                    user_mileage = response!!.body()!!.result[0].user_mileage
                    user_money = response!!.body()!!.result[0].user_money
                }
            }

        })
    }

    fun exchangeMileage(exchange : Int){
        val user_idx = SharedPreference.instance!!.getPrefIntegerData("user_idx")
        val exchangeResponse = networkService.postExchange(user_idx,exchange)
        exchangeResponse.enqueue(object : Callback<BaseModel>{
            override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                if(response!!.isSuccessful){
                    alertDialog!!.dismiss()
                    onResume()
                } else if(response!!.code() == 400){

                }
            }

        })
    }

    override fun onResume() {
        super.onResume()
        getMypage()
    }



}