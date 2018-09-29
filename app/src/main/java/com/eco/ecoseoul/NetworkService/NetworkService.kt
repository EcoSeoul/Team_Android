package com.eco.ecoseoul.NetworkService

import com.eco.ecoseoul.BaseModel
import com.eco.ecoseoul.community.model.ComListResponse
import com.eco.ecoseoul.community.model.ComResponse
import com.eco.ecoseoul.franchise.FranchiseResponse
import com.eco.ecoseoul.franchise.MapsResponse
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
            @Field("user_id") user_id : String,
            @Field("user_pw") user_pw : String
    ) : Call<LoginResponse>

    //3. 마이페이지 - 카드 등록
    @FormUrlEncoded
    @POST("mypage/ecocard")
    fun postEcoCard(
            @Field("user_idx") user_idx : Int,
            @Field("user_barcodenum") user_barcodenum : String
    ) : Call<BaseModel>

    // 마이페이지 - 에코마일리지 및 에코머니 사용내역
    @GET("mypage/usage/{user_idx}/{eco_value}")
    fun getUsages(
            @Path("user_idx") user_idx : Int,
            @Path("eco_value") eco_value : Int
    ) : Call<BaseModel>

    //4. 커뮤니티 리스트 보기
    @GET ("board/list")
    fun getComList (
    ) : Call<ComListResponse>

    //. 커뮤니티 게시글 상세보기
    @GET("board/{board_idx}/{user_idx}")
    fun getComPost(
            @Path("board_idx") board_idx : Int,
            @Path("user_idx") user_idx : Int
    ) : Call<ComResponse>

    //5. 커뮤니티 게시글 작성
    @FormUrlEncoded
    @POST("board")
    fun postWriting(
            @Field("board_title") board_title : String,
            @Field("board_content") board_content : String,
            @Field("user_idx") user_idx : Int
    ) : Call<BaseModel>


    //6. 기부하기
    @FormUrlEncoded
    @POST("donation")
    fun postDation(
            @Field("org_idx") org_idx : Int,
            @Field("org_name") org_name : String,
            @Field("user_idx") user_idx : Int,
            @Field("donation_mileage") donation_mileage : Int
    ) : Call<BaseModel>

    //4. 가맹점 찾기, 위치 불러오기
    @GET("franchise/{gu_idx}")
    fun getFranchises(
            @Path("gu_idx") gu_idx : Int
    ) : Call<FranchiseResponse>

    //5. 가맹점 상세보기
    @GET("franchise/detail/{frc_idx}")
    fun getFranInfo(
            @Path("frc_idx") frc_idx : Int
    ) : Call<MapsResponse>

}