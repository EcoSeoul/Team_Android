package com.eco.ecoseoul.home.view

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.MainActivity
import com.eco.ecoseoul.NetworkService.NetworkService

import com.eco.ecoseoul.home.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.eco.ecoseoul.R
import com.eco.ecoseoul.SharedPreference
import com.eco.ecoseoul.home.model.MainResponse

class LoginActivity : AppCompatActivity() {

    lateinit var idEdit : EditText
    lateinit var pwEdit : EditText
    lateinit var loginButton : Button
    lateinit var networkService: NetworkService

    companion object {
        lateinit var mainData: Response<MainResponse>
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        SharedPreference.instance!!.load(this)
//
//        if(!SharedPreference.instance!!.getPrefStringData("user_name")!!.isEmpty()){
//            getMainItems(SharedPreference.instance!!.get)
//        } else {
//
//        }

        idEdit = findViewById(R.id.login_id_edit)
        pwEdit = findViewById(R.id.login_pw_edit)
        loginButton = findViewById(R.id.login_login_button)

        networkService = ApplicationController!!.instance.networkService
        loginButton.setOnClickListener{v: View? ->
            if(idEdit.text.toString().equals("") || pwEdit.text.toString().equals("")){
                Toast.makeText(this,"ID 또는 PW를 입력해주세요.",Toast.LENGTH_LONG).show()
            } else {
                val loginResponse = networkService.postLogin(idEdit.text.toString(),pwEdit.text.toString())
                loginResponse.enqueue(object : Callback<LoginResponse>{
                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                        Toast.makeText(applicationContext,"서버 오류",Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                        if(response!!.isSuccessful){
                            if(response!!.code() == 400){
                                Toast.makeText(applicationContext,"ID 또는 PW가 맞지 않습니다.",Toast.LENGTH_LONG).show()
                            } else {
                                getMainItems(response!!.body()!!.checkResult[0].user_idx)
                            }
                        } else if(response!!.code() == 400){
                            Toast.makeText(applicationContext,"ID 또는 PW가 맞지 않습니다.",Toast.LENGTH_LONG).show()
                        }
                    }

                })
            }
        }
    }

    fun getMainItems(user_idx : Int){
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
                    var intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Log.d("Network","main Client Error")
                }
            }

        })

    }
}
