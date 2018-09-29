package com.eco.ecoseoul.community.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.community.model.AllPost
import com.eco.ecoseoul.community.model.BestPost
import com.eco.ecoseoul.community.model.CommentPost

class CommunityDetailActivity : AppCompatActivity() {
    lateinit var networkService : NetworkService
    lateinit var commentRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_detail)

        networkService = ApplicationController.instance.networkService
        commentRecycler = findViewById(R.id.com_comment_rv)

        var comment = ArrayList<CommentPost>()


    }
}
