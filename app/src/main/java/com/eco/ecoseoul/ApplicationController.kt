package com.eco.ecoseoul

import android.app.Application
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.home.model.MainResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by minhyoung on 2018. 9. 25..
 */
class ApplicationController : Application() {
    lateinit var networkService : NetworkService
    var mainItems : Response<MainResponse>? = null
    private val baseUrl = "http://13.124.75.47:3000/"
    companion object {
        lateinit var instance : ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }

    fun buildNetwork(){

        val builder = Retrofit.Builder()
        val retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        networkService = retrofit.create(NetworkService::class.java)
    }
}