package com.eco.ecoseoul.mypage.model

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MyBoardResponse (
        @SerializedName("mytext_list")
        @Expose
        var mytext_list : ArrayList<MyTextList>
) : BaseModel()