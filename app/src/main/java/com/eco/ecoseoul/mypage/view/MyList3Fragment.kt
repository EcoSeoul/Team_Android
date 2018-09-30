package com.eco.ecoseoul.mypage.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.NetworkService.NetworkService

import com.eco.ecoseoul.R
import com.eco.ecoseoul.SharedPreference
import com.eco.ecoseoul.mypage.control.GoodsAdapter
import com.eco.ecoseoul.mypage.control.MyPostAdapter
import com.eco.ecoseoul.mypage.model.GoodsResponse
import com.eco.ecoseoul.mypage.model.MyBoardResponse
import com.eco.ecoseoul.mypage.model.MyGoods
import com.eco.ecoseoul.mypage.model.MyTextList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyList3Fragment : Fragment() {

    lateinit var networkService : NetworkService
    lateinit var mypostRecycler : RecyclerView

    var user_idx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {


        val view = inflater!!.inflate(R.layout.fragment_my_list3,container,false)
//        init(view)

        mypostRecycler = view.findViewById(R.id.mypost_list)
        user_idx = SharedPreference.instance!!.getPrefIntegerData("user_idx")

        //통신
        networkService = ApplicationController.instance.networkService

        var mypost = ArrayList<MyTextList>()
        val mypostResponse = networkService.getMyboard(user_idx)
        mypostResponse.enqueue(object : Callback<MyBoardResponse> {
            override fun onFailure(call: Call<MyBoardResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<MyBoardResponse>?, response: Response<MyBoardResponse>?) {
                if(response!!.isSuccessful) {
                    mypost = response!!.body()!!.mytext_list
                    var mypostAdapter : MyPostAdapter = MyPostAdapter(mypost)
                    mypostRecycler.layoutManager = LinearLayoutManager(activity.applicationContext,LinearLayoutManager.VERTICAL,false)
                    mypostRecycler.adapter = mypostAdapter
                }
            }

        })

        return view
    }


}
