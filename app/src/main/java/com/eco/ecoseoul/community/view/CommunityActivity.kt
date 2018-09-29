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
import android.widget.Toast
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.SharedPreference
import com.eco.ecoseoul.community.control.ComAdapter
import com.eco.ecoseoul.community.control.ComBestAdapter
import com.eco.ecoseoul.community.model.AllPost
import com.eco.ecoseoul.community.model.BestPost
import com.eco.ecoseoul.community.model.ComListResponse
import kotlinx.android.synthetic.main.activity_community.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommunityActivity : AppCompatActivity() {

    lateinit var networkService : NetworkService
    lateinit var bestRecycler : RecyclerView
    lateinit var commRecycler : RecyclerView
    var community : ComListResponse? = null
    var img : Int = 0
    var comBest : BestPost? = null

    var user_idx = 0
    var likeFlag = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)

        networkService = ApplicationController.instance.networkService
        bestRecycler = findViewById(R.id.com_best_rv)
        commRecycler = findViewById(R.id.com_rv)

        user_idx =SharedPreference.instance!!.getPrefIntegerData("user_idx")



//        val com_best_title : TextView = findViewById<View>(R.id.com_best_title) as TextView
//        val com_best_contents : TextView = findViewById<View>(R.id.com_best_contents) as TextView
//        val com_best_date : TextView = findViewById<View>(R.id.com_best_date) as TextView
//        val com_best_name : TextView = findViewById<View>(R.id.com_best_name) as TextView


//        var intent = Intent(this.intent)
//        community = intent.getSerializableExtra("community") as? ComListResponse


        // 리사이클러뷰에 아이템 붙이기

        getCommunityList()



        // 글 등록으로 화면 넘어가기
//        com_write_btn.setOnClickListener {v:View->
//            val intent = Intent(this, CommunityWriteActivity::class.java)
//            startActivity(intent)
//        }

        com_write_btn.setOnClickListener { v: View? ->
            val intent = Intent(this, CommunityWriteActivity::class.java)
            startActivity(intent)
        }





    }

    fun getCommunityList(){
        Log.d("asdf","comm resume")
        var best_post = ArrayList<BestPost>()
        var post = ArrayList<AllPost>()
        val comListResponse = networkService.getComList(user_idx)
        comListResponse.enqueue(object : Callback<ComListResponse> {
            override fun onFailure(call: Call<ComListResponse>?, t: Throwable?) {
                Log.d("asdf","ffff")
            }

            override fun onResponse(call: Call<ComListResponse>?, response: Response<ComListResponse>?) {
                if(response!!.isSuccessful) {
                    Log.d("asdf","ssss")

                    //bset list 부분
                    best_post = response!!.body()!!.best_list

                    for(i in 0..response!!.body()!!.best_list.size -1){
                        Log.d("asdfasdf","aaaaa : "+response!!.body()!!.best_list[i].board_title)
                    }

                    var bestAdapter : ComBestAdapter = ComBestAdapter(best_post)

                    bestAdapter.setOnItemClickListener(object : ComBestAdapter.ItemClick{
                        override fun onClick(view: View, position: Int) {
//                            Toast.makeText(this@CommunityActivity,""+best_post[position].board_idx,Toast.LENGTH_LONG).show()

                            Log.d("detail", "sss")


                            var intent = Intent(this@CommunityActivity,CommunityDetailActivity::class.java)
                            intent.putExtra("board_idx",best_post[position].board_idx)
                            intent.putExtra("user_idx",1)
                            startActivity(intent)

                        }

                    })

                    //list 부분
                    post = response!!.body()!!.all_list

                    var listAdapter : ComAdapter = ComAdapter(post)

                    listAdapter.setOnItemClickListener(object  : ComAdapter.ItemClick {
                        override fun onClick(view: View, position: Int) {
//                            Toast.makeText(this@CommunityActivity, ""+post[position].board_idx, Toast.LENGTH_LONG).show()

                            Log.d("detail", "sss")


                            var intent = Intent(this@CommunityActivity,CommunityDetailActivity::class.java)
                            intent.putExtra("board_idx",post[position].board_idx)
                            intent.putExtra("user_idx",user_idx)
                            startActivity(intent)


                        }

                    })


                    bestRecycler.layoutManager = LinearLayoutManager(this@CommunityActivity)
                    bestRecycler.adapter = bestAdapter

                    commRecycler.layoutManager = LinearLayoutManager(this@CommunityActivity)
                    commRecycler.adapter = listAdapter

                }
            }

        })
    }

    override fun onResume() {
        super.onResume()
        getCommunityList()
    }
}
