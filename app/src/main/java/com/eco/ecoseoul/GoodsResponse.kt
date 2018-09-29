package com.eco.ecoseoul

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GoodsResponse (
        @SerializedName("myGoods")
        @Expose
        var myGoods : ArrayList<MyGoods>
) : BaseModel()