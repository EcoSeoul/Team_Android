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
import com.eco.ecoseoul.mypage.model.GoodsResponse
import com.eco.ecoseoul.mypage.model.MyGoods
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyList1Fragment : Fragment() {

    lateinit var networkService : NetworkService
    lateinit var goodsRecycler : RecyclerView

    var user_idx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {


        val view = inflater!!.inflate(R.layout.fragment_my_list1,container,false)
//        init(view)

        goodsRecycler = view.findViewById(R.id.request_list)
        user_idx = SharedPreference.instance!!.getPrefIntegerData("user_idx")

        //통신
        networkService = ApplicationController.instance.networkService

        var goods = ArrayList<MyGoods>()
        val goodsResponse = networkService.getMyGoods(user_idx)
        goodsResponse.enqueue(object : Callback<GoodsResponse> {
            override fun onFailure(call: Call<GoodsResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GoodsResponse>?, response: Response<GoodsResponse>?) {
                if(response!!.isSuccessful) {
                    goods = response!!.body()!!.myGoods
                    var goodsAdapter : GoodsAdapter = GoodsAdapter(goods)
                    goodsRecycler.layoutManager = LinearLayoutManager(activity.applicationContext,LinearLayoutManager.VERTICAL,false)
                    goodsRecycler.adapter = goodsAdapter
                }
            }

        })

        return view
    }


}
