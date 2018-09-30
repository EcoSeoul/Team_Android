package com.eco.ecoseoul.mypage.model

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MileageResponse (
        @SerializedName("milage_total_usage")
        @Expose
        var mileage_total_usage : ArrayList<MileageUsageData>,
        @SerializedName("used_milage")
        @Expose
        var used_mileage : Int,
        @SerializedName("saved_mileage")
        @Expose
        var saved_mileage : Int
) : BaseModel()