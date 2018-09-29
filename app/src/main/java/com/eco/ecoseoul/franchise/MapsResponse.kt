package com.eco.ecoseoul.franchise

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MapsResponse (
    @SerializedName("frc_information")
    @Expose
    var frc_information : ArrayList<FrcInfo>
) : BaseModel()

data class FrcInfo (
        var frc_idx : Int,
        var gu_idx : Int,
        var frc_name : String,
        var frc_lat : Double,
        var frc_long : Double,
        var frc_add : String,
        var frc_phone : String,
        var frc_salepercent : Int,
        var frc_type : Int
)