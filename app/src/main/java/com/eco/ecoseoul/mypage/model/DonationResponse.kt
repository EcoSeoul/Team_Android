package com.eco.ecoseoul.mypage.model

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DonationResponse (
        @SerializedName("myDonations")
        @Expose
        var myDonations : ArrayList<MyDonations>
) : BaseModel()