package com.eco.ecoseoul.NetworkService

import com.eco.ecoseoul.home.model.MainResponse
import com.eco.ecoseoul.home.model.LoginResponse
import com.google.android.gms.common.internal.safeparcel.SafeParcelable
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by minhyoung on 2018. 9. 25..
 */
interface NetworkService {

    //1. 메인 + 모아보기
    @GET("home/{user_idx}")
    fun getMainItems(
            @Path("user_idx") user_idx : Int
    ) : Call<MainResponse>
    //2. 로그인
    @FormUrlEncoded
    @POST("mypage/login")
    fun postLogin(
            @Field("user_id") user_id: String,
            @Field("user_pw") user_pw: String
    ) : Call<LoginResponse>

}