package com.eco.ecoseoul.community.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.BaseModel
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import kotlinx.android.synthetic.main.activity_community_write.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommunityWriteActivity : AppCompatActivity() {
    lateinit var networkService : NetworkService

    lateinit var board_title : EditText
    lateinit var board_content : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_write)

        board_title = findViewById(R.id.board_title)
        board_content = findViewById(R.id.board_content)

        val btn : Button = findViewById(R.id.com_write_btn)
        networkService = ApplicationController.instance.networkService

        btn.setOnClickListener { v: View? ->
            val write = networkService.postWriting(board_title.text.toString(),board_content.text.toString(),1)
            write.enqueue(object : Callback<BaseModel> {
                override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                    if(response!!.isSuccessful) {
                        Log.d("comText", "sss")
                        finish()
                    }
                }

            })
        }
    }
}
