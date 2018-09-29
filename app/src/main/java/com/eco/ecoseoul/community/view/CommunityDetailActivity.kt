package com.eco.ecoseoul.community.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.BaseModel
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.community.control.CommentAdapter
import com.eco.ecoseoul.community.model.CommentPost
import com.eco.ecoseoul.community.model.CommentResponse
import kotlinx.android.synthetic.main.activity_community_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommunityDetailActivity : AppCompatActivity() {
    lateinit var networkService : NetworkService
    lateinit var commentRecycler: RecyclerView
    var board_idx = 0
    var user_idx = 0
    var likeFlag = false

    lateinit var contents_comment_edit : EditText
    lateinit var com_detail_like : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_detail)

        board_idx = intent.getIntExtra("board_idx",0)
        user_idx = intent.getIntExtra("user_idx",0)

        networkService = ApplicationController.instance.networkService
        commentRecycler = findViewById(R.id.com_comment_rv)

        contents_comment_edit = findViewById(R.id.contents_comment_edit)
        com_detail_like = findViewById(R.id.com_detail_like)

        getDetail()
        com_modify.setOnClickListener{ v : View? ->
//            var intent = Intent(this@CommunityDetailActivity,CommunityWriteActivity::class.java)
//            intent.putExtra("flag",1)
//            startActivity(intent)
        }

//        com_delete.setOnClickListener { v:View? ->
//
//        }

//        com_like.setOnClickListener { v: View? ->
//            var like = ArrayList<AllPost>()
//            val comResponse = networkService.getComPost(board_idx, user_idx)
//            comResponse.enqueue(object : Callback<>)
//
//        }

        com_detail_like.setOnClickListener { v: View? ->
            Log.d("asdfasdf","buttonbutton")
            changeLike()
        }

        comment_post_btn.setOnClickListener { v: View? ->

            val comment = networkService.postComment(board_idx, user_idx, contents_comment_edit.text.toString())
            comment.enqueue(object : Callback<BaseModel> {
                override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                    Log.d("comment", "sss")
                    if(response!!.isSuccessful){
                        contents_comment_edit.setText("")
                        onResume()
                    }
                }

            })
        }
    }

    fun changeLike(){
        val like = networkService.postLike(user_idx,board_idx)
        like.enqueue(object : Callback<BaseModel> {
            override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                if(response!!.isSuccessful) {
                    Log.d("asdfasf","likelikelike")
                    if(likeFlag == true) {
                        com_detail_like.setBackgroundResource(R.drawable.community_recommendation_line)
                        likeFlag = false

                    }
                    if(likeFlag == false) {
                        com_detail_like.setBackgroundResource(R.drawable.community_recommendation_color)
                        likeFlag = true

                    }


                    getDetail()
                }
            }

        })
    }

    fun getDetail(){
        var comment = ArrayList<CommentPost>()
        val comResponse = networkService.getComPost(board_idx, user_idx)
        comResponse.enqueue(object : Callback<CommentResponse>{
            override fun onFailure(call: Call<CommentResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<CommentResponse>?, response: Response<CommentResponse>?) {
                if(response!!.isSuccessful) {
                    comment = response!!.body()!!.comment_Result
                    var comAdapter : CommentAdapter = CommentAdapter(comment)
                    commentRecycler.layoutManager = LinearLayoutManager(this@CommunityDetailActivity)
                    commentRecycler.adapter = comAdapter

                    likeFlag = response!!.body()!!.board_Result[0].likeFlag

                    if(likeFlag == true) {
                        com_detail_like.setBackgroundResource(R.drawable.community_recommendation_color)
                    }
                    if(likeFlag == false) {
                        com_detail_like.setBackgroundResource(R.drawable.community_recommendation_line)
                    }

                    if(!response!!.body()!!.board_Result[0].writer_check){
                        com_bar.visibility = View.INVISIBLE
                        com_modify.visibility = View.INVISIBLE
                        com_delete.visibility = View.INVISIBLE
                    }

                    request_text_name.text = response!!.body()!!.board_Result[0].board_title
                    request_text_content.text = response!!.body()!!.board_Result[0].board_content
                    request_text_date.text = response!!.body()!!.board_Result[0].board_date
                    request_text_user.text = response!!.body()!!.board_Result[0].User_name
                    com_commentCount.text = response!!.body()!!.board_Result[0].board_cmtnum.toString()
                    com_likeCount.text = response!!.body()!!.board_Result[0].board_like.toString()


                }
            }

        })
    }

    override fun onResume() {
        super.onResume()
        getDetail()
    }
}
