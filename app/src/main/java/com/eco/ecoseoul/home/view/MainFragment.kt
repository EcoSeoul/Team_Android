package com.eco.ecoseoul.home.view

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.control.ExpandableAdapter
import com.eco.ecoseoul.home.control.bannerAdapter
import com.eco.ecoseoul.home.model.ParentItem

/**
 * Created by minhyoung on 2018. 9. 18..
 */
class MainFragment : Fragment() {
    private final var PARENT : Int = 0
    private final var TEXT : Int = 1
    private final var CHILD : Int = 2

    lateinit var bannerPager : ViewPager
    lateinit var bannerAdapter: bannerAdapter
    lateinit var expandableAdapter: ExpandableAdapter
    lateinit var expandableItems : ArrayList<ParentItem>
    lateinit var expandableRecycler : RecyclerView

    lateinit var goodsButton : ImageButton
    lateinit var donationButton : ImageButton
    lateinit var communityButton : ImageButton
    lateinit var milageButton : ImageButton

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_main,container,false)

        init(view)

        expandableItems = ArrayList()
//        expandableItems.add(ParentItem("에코머니 가맹점 몰 둘러보기",null,null,PARENT))
//        expandableItems.add(ParentItem("포인트 전환 / 결제",null,null,TEXT))
//        expandableItems.add(ParentItem("Top 쇼핑","*에코머니로 결제하실 때는",null,CHILD))
//        expandableItems.add(ParentItem("포인트 적립 / 할인",null,null,TEXT))
//        expandableItems.add(ParentItem("엔진닥터큐(엘더블유티(주))",null,null,CHILD))
//        expandableItems.add(ParentItem("정직한 친구들",null,null,CHILD))

        var parent = ParentItem("에코머니 가맹점 몰 둘러보기",null,null,PARENT)
        parent.invisibleChildren = ArrayList()
        parent.invisibleChildren!!.add(ParentItem("포인트 전환 / 결제",null,null,TEXT))
        parent.invisibleChildren!!.add(ParentItem("Top 쇼핑","*에코머니로 결제하실 때는",null,CHILD))
        parent.invisibleChildren!!.add(ParentItem("포인트 적립 / 할인",null,null,TEXT))
        parent.invisibleChildren!!.add(ParentItem("엔진닥터큐(엘더블유티(주))",null,null,CHILD))
        parent.invisibleChildren!!.add(ParentItem("정직한 친구들",null,null,CHILD))

        expandableItems.add(parent)

        expandableAdapter = ExpandableAdapter(expandableItems)
        expandableRecycler = view.findViewById(R.id.expand_recycler)
        expandableRecycler.layoutManager = LinearLayoutManager(activity.applicationContext,LinearLayoutManager.VERTICAL,false)
        expandableRecycler.adapter = expandableAdapter



        return view
    }


    //Edit by 이민형
    //각 버튼에 맞게 intent 연결해주면 됨
    var buttonClick = View.OnClickListener { v : View ->
        var intent : Intent? = null
        when(v!!.id){
            R.id.main_goods_button->{
                //intent = Intent(activity.applicationContext,)
                Toast.makeText(activity.applicationContext,"goods",Toast.LENGTH_SHORT)
            }
            R.id.main_donation_button->{
                //intent = Intent(activity.applicationContext,)
                Toast.makeText(activity.applicationContext,"donation",Toast.LENGTH_SHORT)
            }
            R.id.main_community_button->{
                //intent = Intent(activity.applicationContext,)
                Toast.makeText(activity.applicationContext,"community",Toast.LENGTH_SHORT)
            }
            R.id.main_milage_button->{
                //intent = Intent(activity.applicationContext,)
                Toast.makeText(activity.applicationContext,"milage",Toast.LENGTH_SHORT)
            }
        }
        //startActivity(intent)
    }


    fun init(view : View){
        bannerAdapter = bannerAdapter(activity.applicationContext)
        bannerPager = view.findViewById(R.id.main_banner_pager)

        bannerPager.adapter = bannerAdapter
        bannerPager.invalidate()

        goodsButton = view.findViewById(R.id.main_goods_button)
        donationButton = view.findViewById(R.id.main_donation_button)
        communityButton = view.findViewById(R.id.main_community_button)
        milageButton = view.findViewById(R.id.main_milage_button)

        goodsButton.setOnClickListener(buttonClick)
        donationButton.setOnClickListener(buttonClick)
        communityButton.setOnClickListener(buttonClick)
        milageButton.setOnClickListener(buttonClick)
    }

}