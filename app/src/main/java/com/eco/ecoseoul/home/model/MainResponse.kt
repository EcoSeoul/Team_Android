package com.eco.ecoseoul.home.model

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by minhyoung on 2018. 9. 26..
 */
data class MainResponse (
     @SerializedName("term")
     @Expose
     var term : ArrayList<Int>,
     @SerializedName("carbon")
     @Expose
     var carbon : ArrayList<Int>,
     @SerializedName("pastCarbon")
     @Expose
     var pastCarbon : ArrayList<Int>,
     @SerializedName("totalCarbon")
     @Expose
     var totalCarbon : Int,
     @SerializedName("usageData")
     @Expose
     var usageData : usageDataList,
     @SerializedName("userInfo")
     @Expose
     var userInfo : ArrayList<UserInfo>
) : BaseModel()

data class UserInfo(
        var user_barcodenum : Int,
        var user_mileage : Int
)

data class usageDataList(
        var elec : usageItem,
        var water : usageItem,
        var gas : usageItem,
        var carbon : usageItem
)

data class usageItem(
        var up_down : Int,
        var percentage : Int,
        var past : Int,
        var present : Int
)