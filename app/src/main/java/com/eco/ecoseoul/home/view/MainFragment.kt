package com.eco.ecoseoul.home.view

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
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
import android.widget.*
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.SharedPreference
import com.eco.ecoseoul.donation.view.DonationActivity
import com.eco.ecoseoul.home.control.ExpandableAdapter
import com.eco.ecoseoul.home.control.bannerAdapter
import com.eco.ecoseoul.home.model.MainResponse
import com.eco.ecoseoul.home.model.ParentItem
import com.eco.ecoseoul.shop.view.ShopActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

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

    var scrollView : ScrollView? = null


    lateinit var mypageButton : ImageButton
    lateinit var barcodeImage : ImageView
    lateinit var barcodeText : TextView
    lateinit var mileageText : TextView

    lateinit var franchiseButton : ImageButton
    lateinit var goodsButton : ImageButton
    lateinit var donationButton : ImageButton
    lateinit var communityButton : ImageButton
    lateinit var milageButton : ImageButton
    lateinit var v : View
    lateinit var mLayoutInflater : LayoutInflater
    lateinit var mainData : Response<MainResponse>

    lateinit var networkService : NetworkService

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mLayoutInflater = inflater!!
        v = mLayoutInflater!!.inflate(R.layout.fragment_main,container,false)
        init(v)

        mainData = LoginActivity.mainData

        //var barcodeData = mainData!!.body()!!.userInfo[0].user_barcodenum.toString()
        var barcodeData : String? = null

        if(barcodeData == null){ //바코드 없을 때
            barcodeText.text = "카드 등록하기"
            barcodeText.visibility = View.VISIBLE
            barcodeImage.visibility = View.GONE
        } else { // 바코드 있을 때
            try {
                barcodeText.visibility = View.GONE
                barcodeImage.visibility = View.VISIBLE
                var bitmap = encodeAsBitmap(barcodeData,BarcodeFormat.CODE_128,600,300)
                barcodeImage.setImageBitmap(bitmap)
            } catch (e : WriterException){
                e.printStackTrace()
            }
        }

        mileageText.text = "에코 마일리지 "+mainData!!.body()!!.userInfo[0].user_mileage
        expandableItems = ArrayList()

        var parent = ParentItem("에코머니 가맹점 몰 둘러보기",null,null,PARENT)
        parent.invisibleChildren = ArrayList()
        parent.invisibleChildren!!.add(ParentItem("포인트 전환 / 결제",null,null,TEXT))
        parent.invisibleChildren!!.add(ParentItem("Top 쇼핑",
                "*에코머니 포인트로 결제하실 때는\r\n결제화면에서 에코머니 비밀번호를 입력하셔야 합니다.",
                null,CHILD))
        parent.invisibleChildren!!.add(ParentItem("포인트 적립 / 할인",null,null,TEXT))
        parent.invisibleChildren!!.add(ParentItem("엔진닥터큐(엘더블유티(주))",null,null,CHILD))
        parent.invisibleChildren!!.add(ParentItem("정직한 친구들",null,null,CHILD))

        expandableItems.add(parent)

        expandableAdapter = ExpandableAdapter(expandableItems)
        expandableRecycler = v.findViewById(R.id.expand_recycler)
        expandableRecycler.layoutManager = LinearLayoutManager(activity.applicationContext,LinearLayoutManager.VERTICAL,false)
        expandableRecycler.adapter = expandableAdapter
        expandableRecycler.isNestedScrollingEnabled = false


        return v
    }


    //Edit by 이민형
    //각 버튼에 맞게 intent 연결해주면 됨
    var buttonClick = View.OnClickListener { v : View ->
        var intent : Intent? = null
        when(v!!.id){
            R.id.main_franchise_button->{//가맹점 찾기 버튼

            }
            R.id.main_goods_button->{//샵 가기 버튼
                intent = Intent(activity,ShopActivity::class.java)
                startActivity(intent)
            }
            R.id.main_donation_button->{ //기부하러가기 버튼
                intent = Intent(activity,DonationActivity::class.java)
                startActivity(intent)

            }
            R.id.main_community_button->{//커뮤니티 보기 버튼
                //intent = Intent(activity.applicationContext,)
                Toast.makeText(activity.applicationContext,"community",Toast.LENGTH_SHORT).show()
            }
            R.id.main_milage_button->{//마일리지 설명 버튼
                //intent = Intent(activity.applicationContext,)
                Toast.makeText(activity.applicationContext,"milage",Toast.LENGTH_SHORT).show()
            }
            R.id.barcode_mypage_button->{ //마이페이지 버튼
                Log.d("mainFrag","mypage")
            }
            R.id.main_barcode_text->{ // 에코머니 등록
                var ecomoneyDialog = CardRegiDialog(activity)
                ecomoneyDialog.window.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
                ecomoneyDialog.show()
            }
            R.id.home_barcode_image->{ //바코드 확인
                var bitmap = encodeAsBitmap(mainData!!.body()!!.userInfo[0].user_barcodenum.toString(),BarcodeFormat.CODE_128,600,300)
                var mileage = mainData!!.body()!!.userInfo[0].user_mileage
                var name = SharedPreference.instance!!.getPrefStringData("user_name")

                var barcodeDialog = BarcodeDialog(activity,bitmap!!,mileage,name!!)
                barcodeDialog.window.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
                barcodeDialog.show()

            }
        }
        //startActivity(intent)
    }


    fun init(view : View){
        bannerAdapter = bannerAdapter(activity.applicationContext)
        bannerPager = view.findViewById(R.id.main_banner_pager)

        bannerPager.adapter = bannerAdapter
        bannerPager.invalidate()

        franchiseButton = view.findViewById(R.id.main_franchise_button)
        goodsButton = view.findViewById(R.id.main_goods_button)
        donationButton = view.findViewById(R.id.main_donation_button)
        communityButton = view.findViewById(R.id.main_community_button)
        milageButton = view.findViewById(R.id.main_milage_button)

        mypageButton = view.findViewById(R.id.barcode_mypage_button)
        barcodeImage = view.findViewById(R.id.home_barcode_image)
        mileageText = view.findViewById(R.id.barcode_mileage_text)
        barcodeText = view.findViewById(R.id.main_barcode_text)
        barcodeText.setOnClickListener(buttonClick)
        barcodeImage.setOnClickListener(buttonClick)


        mypageButton.visibility = View.GONE


        franchiseButton.setOnClickListener(buttonClick)
        goodsButton.setOnClickListener(buttonClick)
        donationButton.setOnClickListener(buttonClick)
        communityButton.setOnClickListener(buttonClick)
        milageButton.setOnClickListener(buttonClick)
        mypageButton.setOnClickListener(buttonClick)

        scrollView = view.findViewById(R.id.main_scroll_view)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser){
//            var exchanged = v.findViewById<RelativeLayout>(R.id.barcode_standard_layout)
//            mLayoutInflater.inflate(R.layout.barcode_exchange_item,exchanged)
            mypageButton.visibility = View.VISIBLE
            scrollView!!.fullScroll(ScrollView.FOCUS_UP)
        } else {
            if(scrollView != null){

//                var exchanged = v.findViewById<RelativeLayout>(R.id.barcode_exchange_layout)
//                mLayoutInflater.inflate(R.layout.barcode_standard_item,exchanged)
                mypageButton.visibility = View.GONE
                scrollView!!.fullScroll(ScrollView.FOCUS_UP)
            }
        }
    }

    fun encodeAsBitmap(contents : String, format : BarcodeFormat, img_width : Int, img_height : Int) : Bitmap?{

        var WHITE  = 0xFFFFFFFF
        var BLACK = 0xFF000000

        var contentsToEncode = contents
        if(contentsToEncode == null){
            return null
        }

        var hints : Map<EncodeHintType,String>? = null

        var encoding = "UTF-8"
        if(encoding != null){
            hints = EnumMap<EncodeHintType,String>(EncodeHintType::class.java)
            hints.put(EncodeHintType.CHARACTER_SET,encoding)
        }

        var writer : MultiFormatWriter = MultiFormatWriter()

        var result : BitMatrix? = null

        result = writer.encode(contentsToEncode,format,img_width,img_height,hints)
        var width = result.width
        var height = result.height
        val pixels = IntArray(width * height)

        for(y in 0..(height-1)){
            var offset = y * width
            for(x in 0..(width-1)){
                pixels[offset + x] = if(result.get(x,y)) BLACK.toInt() else WHITE.toInt()
            }
        }

        var bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888)
        bitmap.setPixels(pixels,0,width,0,0,width,height)

        return bitmap
    }

//    fun guessAppropriateEncoding(contents : CharSequence) : String?{
//        for(i in 0..contents.length){
//            if (contents.get(i) > 0xFF as Char) {
//                return "UTF-8"
//            }
//        }
//
//        return null
//    }

}