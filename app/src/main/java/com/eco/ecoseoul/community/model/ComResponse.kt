package com.eco.ecoseoul.community.model

import com.eco.ecoseoul.BaseModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComResponse (
        @SerializedName("board_Result")
        @Expose
        var board_Result : ArrayList<BoardResult>,
        @SerializedName("comment_Result")
        @Expose
        var comment_Result : ArrayList<CommentResult>
) : BaseModel()

data class BoardResult(
        var board_idx : Int,
        var board_title : String,
        var board_content : String,
        var board_date : String,
        var user_idx : Int,
        var board_like : Int,
        var board_cmtnum : Int,
        var user_ID : String,
        var writer_check : Boolean
)

data class CommentResult (
        var cmt_idx : Int,
        var cmt_content : String,
        var cmt_date : String,
        var user_idx : Int,
        var board_idx : Int,
        var user_ID : String,
        var writer_check : Boolean
)