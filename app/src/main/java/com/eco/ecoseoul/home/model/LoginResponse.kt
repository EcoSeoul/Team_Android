package com.eco.ecoseoul.home.model

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by minhyoung on 2018. 9. 26..
 */
data class LoginResponse (
        @SerializedName("checkResult")
        @Expose
        var checkResult : ArrayList<loginData>
) : BaseModel()

data class loginData(
        var user_idx : Int,
        var user_ID : String,
        var user_pw : String,
        var user_name : String,
        var user_barcodenum : String,
        var user_mileage : Int,
        var user_money : Int,
        var user_join_date : String
)