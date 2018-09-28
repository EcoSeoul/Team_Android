package com.eco.ecoseoul

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import com.eco.ecoseoul.NetworkService.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationActivity : AppCompatActivity() {

    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        //button
        val btn : Button = findViewById<View>(R.id.card_ok) as Button
        var edt : EditText = findViewById(R.id.card_edit)


        networkService = ApplicationController.instance.networkService

        btn.setOnClickListener {
            val card = networkService.postEcoCard(1,edt.text.toString())
            card.enqueue(object : Callback<BaseModel> {
                override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                    if(response!!.isSuccessful) {

                        if(edt.text.toString().equals("") ){
                            Toast.makeText(this@RegistrationActivity,"카드 번호를 입력해주세요!",Toast.LENGTH_SHORT).show()
                        } else {
                            Log.d("card", "sss")
                            var intent = Intent(this@RegistrationActivity,RegistrationDialog::class.java)
                            startActivity(intent)
                        }
                    }
                }

            })

        }

        edt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var text  = s.toString().trim()
                if(text.length >= 6) {
                    btn.setBackgroundResource(R.drawable.card_after_btn_style)
                    btn.setTextColor(Color.WHITE)
                    btn.setEnabled(true)
                } else if (text.length < 6){
                    btn.setBackgroundResource(R.drawable.card_before_btn_style)
                    btn.setTextColor(Color.parseColor("#26D07C"))
                    btn.setEnabled(false)

                }

            }
        })


        val listItemsTxt = arrayOf("카드사 선택", "우리은행", "SC제일", "NH농협", "IBK기업")

        var spinnerAdapter: CardSpinnerAdapter = CardSpinnerAdapter(this, listItemsTxt)

        var spinner: Spinner = findViewById<View>(R.id.card_spinner) as Spinner
        spinner?.adapter = spinnerAdapter

        spinner.setSelection(0)

    }

}