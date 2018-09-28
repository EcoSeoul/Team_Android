package com.eco.ecoseoul.community.model

data class CommentPost (
        var cmt_idx : Int,
        var cmt_content : String,
        var cmt_date : String,
        var user_idx : Int,
        var board_idx : Int,
        var user_ID : String,
        var writer_check : Boolean
)
