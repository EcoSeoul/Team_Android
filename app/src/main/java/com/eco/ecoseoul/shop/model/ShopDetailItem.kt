package com.eco.ecoseoul.shop.model

/**
 * Created by minhyoung on 2018. 9. 29..
 */
data class ShopDetailItem (
        var goods_idx : Int,
        var goods_name : String,
        var goods_company : String,
        var goods_content : String,
        var goods_price : Int,
        var goods_img : String,
        var goods_summery : String
)