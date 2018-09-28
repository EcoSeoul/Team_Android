package com.eco.ecoseoul.community.model

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComListResponse (
        @SerializedName("best_list")
        @Expose
        var best_list : ArrayList<BestPost>,
        @SerializedName("all_list")
        @Expose
        var all_list : ArrayList<AllPost>

) : BaseModel()
