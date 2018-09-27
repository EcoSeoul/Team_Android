package com.eco.ecoseoul.home.model

import android.graphics.drawable.Drawable

/**
 * Created by minhyoung on 2018. 9. 26..
 */
data class AllUsageItem (
        var image : Drawable,
        var month : String,
        var arrow : Int,
        var usage : String,
        var percentage : String
)