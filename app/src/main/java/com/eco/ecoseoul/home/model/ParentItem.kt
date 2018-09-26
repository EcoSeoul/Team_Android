package com.eco.ecoseoul.home.model

import android.widget.ImageButton
import android.widget.TextView

/**
 * Created by minhyoung on 2018. 9. 19..
 */
data class ParentItem (
        var parentText : String,
        var editionalText : String?,
        var invisibleChildren : ArrayList<ParentItem>?,
        var type : Int
)