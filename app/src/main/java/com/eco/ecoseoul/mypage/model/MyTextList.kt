package com.eco.ecoseoul.mypage.model

data class MyTextList (
        var board_idx : Int,
        var board_title : String,
        var board_content : String,
        var board_date : String,
        var user_idx : Int,
        var board_like : Int,
        var user_name : String,
        var board_cmtnum : Int
)