package com.eco.ecoseoul

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by minhyoung on 2018. 9. 25..
 */
open class BaseModel (
        @SerializedName("status")
        @Expose
        open var status : Boolean?=null,
        @SerializedName("message")
        @Expose
        open var message : String?=null
)