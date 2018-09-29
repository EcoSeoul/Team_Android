package com.eco.ecoseoul.shop.model

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by minhyoung on 2018. 9. 29..
 */
data class ShopDetailResponse (
        @SerializedName("shopDetail")
        @Expose
        var shopDetail : ArrayList<ShopDetailItem>
) : BaseModel()