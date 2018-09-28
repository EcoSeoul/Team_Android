package com.eco.ecoseoul.community.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CommentResponse (
        @SerializedName("board_Result")
        @Expose
        var board_Result : ArrayList<AllPost>,
        @SerializedName("comment_Result")
        @Expose
        var comment_Result : ArrayList<CommentPost>
)