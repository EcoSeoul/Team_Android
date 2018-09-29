package com.eco.ecoseoul.mypage

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MileageResponse (
        @SerializedName("mileage_total_usage")
        @Expose
        var mileage_total_usage : ArrayList<Mileage>
) : BaseModel()