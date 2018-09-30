package com.eco.ecoseoul.mypage.model

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by minhyoung on 2018. 9. 30..
 */
data class MypageResponse (
        @SerializedName("result")
        @Expose
        var result : ArrayList<myData>
) : BaseModel()

data class myData(
        var user_idx : Int,
        var user_mileage : Int,
        var user_money : Int
)