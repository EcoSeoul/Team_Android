package com.eco.ecoseoul

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class ShopDialog : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shop_complete)
        val handler = Handler()
        handler.postDelayed({
            finish()
        },3000)
    }
}