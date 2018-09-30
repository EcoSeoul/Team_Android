package com.eco.ecoseoul.shop.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.mypage.view.MypageActivity
import com.eco.ecoseoul.shop.control.ShopListAdapter
import com.eco.ecoseoul.shop.model.ShopItem
import kotlinx.android.synthetic.main.activity_shop2.*

class ShopActivity : AppCompatActivity() {

    lateinit var mypageButton : ImageButton
    lateinit var shopListRecycler : RecyclerView
    lateinit var shopListAdapter : ShopListAdapter
    lateinit var networkService: NetworkService
    lateinit var shoplistItems : ArrayList<ShopItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //서버에서 처리
//        setContentView(R.layout.activity_shop)
//
//        shopListRecycler = findViewById(R.id.shop_list_recycler)
//        mypageButton = findViewById(R.id.shop_mypage_button)
//
//        networkService = ApplicationController!!.instance.networkService
//
//        val shopListResponse = networkService.getShopList()
//        shopListResponse.enqueue(object : Callback<ShopListResponse>{
//            override fun onFailure(call: Call<ShopListResponse>?, t: Throwable?) {
//
//            }
//
//            override fun onResponse(call: Call<ShopListResponse>?, response: Response<ShopListResponse>?) {
//                if(response!!.isSuccessful){
//                    var layoutmanager = GridLayoutManager(this@ShopActivity,2)
//
//                    shoplistItems = response!!.body()!!.shopData
//                    shopListAdapter = ShopListAdapter(shoplistItems)
//                    shopListAdapter.setOnItemClickListener(object : ShopListAdapter.ItemClick{
//                        override fun onClick(view: View, position: Int) {
//                            var intent = Intent(this@ShopActivity,ShopDetailActivity::class.java)
//                            intent.putExtra("goods_idx",shoplistItems.get(position).goods_idx)
//                            startActivity(intent)
//                        }
//                    })
//                    shopListRecycler.layoutManager = layoutmanager
//                    shopListRecycler.adapter = shopListAdapter
//
//                }
//            }
//
//        })
//
//
//        mypageButton.setOnClickListener{ v: View? ->
//            var intent = Intent(this@ShopActivity,MypageActivity::class.java)
//            startActivity(intent)
//        }



        //클라에서 처리

        setContentView(R.layout.activity_shop2)

        shop_mypage.setOnClickListener {
            var intent = Intent(this@ShopActivity, MypageActivity::class.java)
            startActivity(intent)
        }
        var onclick = View.OnClickListener { v : View? ->
            var goods_idx = 0
            when(v!!.id){
                R.id.shop_tmoney->{
                    goods_idx = 20
                }
                R.id.shop_apartment->{
                    goods_idx = 18
                }
                R.id.shop_onnuri->{
                    goods_idx = 14
                }
                R.id.shop_stand->{
                    goods_idx = 10
                }
                R.id.shop_tent->{
                    goods_idx = 8
                }
                R.id.shop_changeMoney->{
                    goods_idx = 21
                }
                R.id.shop_concent->{
                    goods_idx = 17
                }
                R.id.shop_culture->{
                    goods_idx = 15
                }
                R.id.shop_tumbler->{
                    goods_idx = 9
                }
            }
            var intent = Intent(this@ShopActivity,ShopDetailActivity::class.java)
            intent.putExtra("goods_idx",goods_idx)
            startActivity(intent)
        }

        shop_tmoney.setOnClickListener(onclick)
        shop_apartment.setOnClickListener(onclick)
        shop_onnuri.setOnClickListener(onclick)
        shop_stand.setOnClickListener(onclick)
        shop_tent.setOnClickListener(onclick)
        shop_changeMoney.setOnClickListener(onclick)
        shop_concent.setOnClickListener(onclick)
        shop_culture.setOnClickListener(onclick)
        shop_tumbler.setOnClickListener(onclick)

    }
}
