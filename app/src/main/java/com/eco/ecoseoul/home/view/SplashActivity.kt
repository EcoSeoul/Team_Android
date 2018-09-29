package com.eco.ecoseoul.home.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.MainActivity
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.SharedPreference
import com.eco.ecoseoul.home.model.MainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity() {

    lateinit var splashImage : ImageView
    lateinit var networkService: NetworkService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        SharedPreference.instance!!.load(this)
        networkService = ApplicationController!!.instance.networkService
        splashImage = findViewById(R.id.splash_image)
        var gifTarget = GlideDrawableImageViewTarget(splashImage)
        Glide.with(this).load(R.drawable.splashios).into(gifTarget)
        val handler = Handler()
        handler.postDelayed({
            if(SharedPreference.instance!!.getPrefStringData("user_name")!!.isEmpty()){
                var intent = Intent(this@SplashActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                var user_idx = SharedPreference.instance!!.getPrefIntegerData("user_idx")
                val mainResponse = networkService.getMainItems(user_idx)
                mainResponse.enqueue(object : Callback<MainResponse>{
                    override fun onFailure(call: Call<MainResponse>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<MainResponse>?, response: Response<MainResponse>?) {
                        if(response!!.isSuccessful){
                            ApplicationController!!.instance.mainItems = response
                            var intent = Intent(this@SplashActivity,MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

                })
            }
        }, 3800)

    }
}
