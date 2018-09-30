package com.eco.ecoseoul.mypage.model

/**
 * Created by minhyoung on 2018. 9. 30..
 */
data class FAQItem (
        var flag : Int,
        var text : String,
        var invisibleChildren : ArrayList<FAQItem>?
)