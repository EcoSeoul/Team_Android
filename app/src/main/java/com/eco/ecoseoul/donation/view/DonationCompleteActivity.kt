package com.eco.ecoseoul.donation.view

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import com.eco.ecoseoul.R

/**
 * Created by minhyoung on 2018. 9. 28..
 */
class DonationCompleteActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shop_complete)
        val handler = Handler()
        handler.postDelayed({
            finish()
        },3000)
    }
}