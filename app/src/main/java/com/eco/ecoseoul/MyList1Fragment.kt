package com.eco.ecoseoul

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import com.eco.ecoseoul.NetworkService.NetworkService


class MyList1Fragment : Fragment() {


    lateinit var networkService: NetworkService
    lateinit var goodsRecycler: RecyclerView

    var user_idx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        networkService = ApplicationController.instance.networkService



    }
}
