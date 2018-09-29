package com.eco.ecoseoul.NetworkService

import com.eco.ecoseoul.BaseModel
import com.eco.ecoseoul.community.model.ComListResponse
import com.eco.ecoseoul.community.model.ComResponse
import com.eco.ecoseoul.home.model.MainResponse
import com.eco.ecoseoul.home.model.LoginResponse
import com.eco.ecoseoul.shop.model.ShopDetailResponse
import com.eco.ecoseoul.shop.model.ShopListResponse
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

    //. 마이페이지 - 카드 등록
    @FormUrlEncoded
    @POST("mypage/ecocard")
    fun postEcoCard(
            @Field("user_idx") user_idx : Int,
            @Field("user_barcodenum") user_barcodenum : String
    ) : Call<BaseModel>

    //. 커뮤니티 리스트 보기
    @GET ("board/list")
    fun getComList (
    ) : Call<ComListResponse>

    //. 커뮤니티 게시글 상세보기
    @GET("board/{board_idx}/{user_idx}")
    fun getComPost(
            @Path("board_idx") board_idx : Int,
            @Path("user_idx") user_idx : Int
    ) : Call<ComResponse>

    //. 커뮤니티 게시글 작성
    @FormUrlEncoded
    @POST("board")
    fun postWriting(
            @Field("board_title") board_title : String,
            @Field("board_content") board_content : String,
            @Field("user_idx") user_idx : Int
    ) : Call<BaseModel>


    //3. 기부하기
    @FormUrlEncoded
    @POST("donation")
    fun postDation(
            @Field("org_idx") org_idx : Int,
            @Field("org_name") org_name : String,
            @Field("user_idx") user_idx : Int,
            @Field("donation_mileage") donation_mileage : Int
    ) : Call<BaseModel>

    //샵 상품 목록
    @GET("shop")
    fun getShopList() : Call<ShopListResponse>

    //샵 상품 상세보기
    @GET("shop/{goods_idx}")
    fun getShopDetail(
            @Path("goods_idx") goods_idx : Int
    ) : Call<ShopDetailResponse>

    //샵 상품 신청하기
    @FormUrlEncoded
    @POST("shop")
    fun postShop(
            @Field("goods_idx") goods_idx: Int,
            @Field("goods_name") goods_name : String,
            @Field("goods_price") goods_price : Int,
            @Field("user_idx") user_idx : Int
    ) : Call<BaseModel>
}