package com.eco.ecoseoul.shop.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.BaseModel
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.SharedPreference
import com.eco.ecoseoul.donation.view.DonationCompleteActivity
import com.eco.ecoseoul.shop.model.ShopDetailItem
import com.eco.ecoseoul.shop.model.ShopDetailResponse
import kotlinx.android.synthetic.main.activity_shop_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopDetailActivity : AppCompatActivity() {

    lateinit var shopDetailItem : ShopDetailItem
    lateinit var networkService: NetworkService
    lateinit var goodsName : TextView
    lateinit var goodsPrice : TextView
    lateinit var goods_company : TextView
    lateinit var goods_image : ImageView
    lateinit var goods_content : TextView
    lateinit var goods_summary : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_detail)

        goodsName = findViewById(R.id.goods_name)
        goods_company = findViewById(R.id.goods_company)
        goods_image = findViewById(R.id.goods_image)
        goods_content = findViewById(R.id.goods_content)
        goods_summary = findViewById(R.id.goods_summary)

        var goods_idx = intent.getIntExtra("goods_idx",0)
        var user_idx = SharedPreference!!.instance!!.getPrefIntegerData("user_idx")
        var goods_name : String? = null
        var goods_price = 0

        networkService = ApplicationController!!.instance.networkService
        val detailResponse = networkService.getShopDetail(goods_idx)
        detailResponse.enqueue(object : Callback<ShopDetailResponse>{
            override fun onFailure(call: Call<ShopDetailResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<ShopDetailResponse>?, response: Response<ShopDetailResponse>?) {
                if(response!!.isSuccessful){
                    shopDetailItem = response!!.body()!!.shopDetail[0]
                    goodsName.text = shopDetailItem.goods_name
                    goods_company.text = shopDetailItem.goods_company
                    goods_content.text = shopDetailItem.goods_content
                    goods_summary.text = shopDetailItem.goods_summery
                    Glide.with(this@ShopDetailActivity).load(shopDetailItem.goods_img).into(goods_image)
                    goods_name = shopDetailItem.goods_name
                    goods_price = shopDetailItem.goods_price

                }
            }

        })

        shop_detail_purchase_button.setOnClickListener { v: View? ->
            if(goods_name == null){
                Toast.makeText(this@ShopDetailActivity,"잠시 기다려주세요.",Toast.LENGTH_LONG).show()
            } else {
                val purchaseResponse = networkService.postShop(goods_idx,goods_name!!,goods_price,user_idx)
                purchaseResponse.enqueue(object : Callback<BaseModel>{
                    override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                        if(response!!.isSuccessful){
                            var intent = Intent(this@ShopDetailActivity,DonationCompleteActivity::class.java)
                            startActivity(intent)
                        }
                    }

                })
            }

        }
    }
}
