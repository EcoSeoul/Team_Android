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
import com.eco.ecoseoul.mypage.control.DonationAdapter
import com.eco.ecoseoul.mypage.control.GoodsAdapter
import com.eco.ecoseoul.mypage.model.DonationResponse
import com.eco.ecoseoul.mypage.model.GoodsResponse
import com.eco.ecoseoul.mypage.model.MyDonations
import com.eco.ecoseoul.mypage.model.MyGoods
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyList2Fragment : Fragment() {

    lateinit var networkService : NetworkService
    lateinit var donationRecycler : RecyclerView

    var user_idx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, avedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_my_list2,container,false)

        donationRecycler = view.findViewById(R.id.donation_list)
        user_idx = SharedPreference.instance!!.getPrefIntegerData("user_idx")

        //통신
        networkService = ApplicationController.instance.networkService

        var donation = ArrayList<MyDonations>()
        val donationResponse = networkService.getMydonation(user_idx)
        donationResponse.enqueue(object : Callback<DonationResponse> {
            override fun onFailure(call: Call<DonationResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<DonationResponse>?, response: Response<DonationResponse>?) {
                if(response!!.isSuccessful) {
                    donation = response!!.body()!!.myDonations
                    var donationAdapter : DonationAdapter = DonationAdapter(donation)
                    donationRecycler.layoutManager = LinearLayoutManager(activity.applicationContext,LinearLayoutManager.VERTICAL,false)
                    donationRecycler.adapter = donationAdapter
                }
            }

        })

        return view
    }


}
