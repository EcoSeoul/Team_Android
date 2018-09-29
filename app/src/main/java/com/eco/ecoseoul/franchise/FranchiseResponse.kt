package com.eco.ecoseoul.franchise

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FranchiseResponse (
    @SerializedName("data")
    @Expose
    var data : ArrayList<FrcData>
) : BaseModel()

data class FrcData (
        var frc_idx : Int,
        var gu_idx : Int,
        var frc_lat : Double,
        var frc_long : Double
)