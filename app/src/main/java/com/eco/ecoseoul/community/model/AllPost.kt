package com.eco.ecoseoul.community.model

data class AllPost(
        var board_idx : Int,
        var board_title : String,
        var board_content : String,
        var board_date : String,
        var user_idx : Int,
        var board_like : Int,
        var board_cmtnum : Int,
        var User_name : String,
        var writer_check : Boolean,
        var likeFlag : Boolean
)