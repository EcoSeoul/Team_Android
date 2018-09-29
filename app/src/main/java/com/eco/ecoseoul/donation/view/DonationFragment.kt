package com.eco.ecoseoul.donation.view

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.BaseModel
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
import com.eco.ecoseoul.SharedPreference
import com.eco.ecoseoul.donation.control.DonationSpinnerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by minhyoung on 2018. 9. 27..
 */
class DonationFragment : Fragment() {

    lateinit var donationImage : ImageView
    lateinit var donationDetailButton : LinearLayout
    lateinit var donationIconImage : ImageView
    lateinit var donationTitleText : TextView
    lateinit var donationExplainText : TextView
    lateinit var donationSpinner : Spinner
    lateinit var donationDonateButton : Button

    var org_idx : Int = 0
    var org_name : String? = null
    var user_idx : Int = 0
    var donation_mileage : Int = 0

    lateinit var networkService : NetworkService

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_donation,container,false)
        var url : String? = null
        val spinnerList = arrayOf("금액 선택","10000 M","20000 M")
        init(view)

        user_idx = SharedPreference.instance!!.getPrefIntegerData("user_idx")
        networkService = ApplicationController!!.instance.networkService


        var spinnerAdapter = DonationSpinnerAdapter(activity,spinnerList,donationDonateButton)

        when(arguments.getInt("donation")){
            0->{
                donationImage.setBackgroundResource(R.drawable.donation_1_banner)
                donationIconImage.setBackgroundResource(R.drawable.donation_tree)
                donationTitleText.text = "사막화 방지를 위한 나무 기부"
                donationExplainText.isScrollbarFadingEnabled = false
                donationExplainText.text =
                        "사막화, 황사를 막을 수 있는 유일한 해결책은 나무를 심는 일입니다.\r\n" +
                        "한 사람이 평생 열 그루의 나무를 심는다면 기후변화, 사막화, 황사를 방지할 수 있습니다.\r\n" +
                        "이는 나무 열 그루를 심어 이산화탄소를 흡수하는 효과도 크겠지만 더 중요한 것은 사람들의 마음과 삶의 변화를 뜻하는 것입니다. 사람의 마음이 바뀌면 기후변화, 사막화 문제도 해결될 수 있습니다.\r\n" +
                        "에코마일리지 회원들의 기부는 나무 한 그루, 한 그루가 모여 숲이 이루어지듯 사막화 방지의 큰 밑거름이 될 것입니다"
                donationExplainText.movementMethod = ScrollingMovementMethod()
                url = "http://www.greenasia.kr/"
                org_idx = 1
                org_name = "푸른아시아"
            }
            1->{
                donationImage.setBackgroundResource(R.drawable.donation_2_banner)
                donationIconImage.setBackgroundResource(R.drawable.donation_tree)
                donationTitleText.text = "사막화 방지를 위한 나무 기부"
                donationExplainText.text =
                        "사막화, 황사를 막을 수 있는 유일한 해결책은 나무를 심는 일입니다.\r\n" +
                        "한 사람이 평생 열 그루의 나무를 심는다면 기후변화, 사막화, 황사를 방지할 수 있습니다.\r\n" +
                        "이는 나무 열 그루를 심어 이산화탄소를 흡수하는 효과도 크겠지만 더 중요한 것은 사람들의 마음과 삶의 변화를 뜻하는 것입니다. 사람의 마음이 바뀌면 기후변화, 사막화 문제도 해결될 수 있습니다.\r\n" +
                        "에코마일리지 회원들의 기부는 나무 한 그루, 한 그루가 모여 숲이 이루어지듯 사막화 방지의 큰 밑거름이 될 것입니다"
                donationExplainText.movementMethod = ScrollingMovementMethod()
                url = "http://www.futureforest.org/"
                org_idx = 2
                org_name = "미래숲"
            }
            2->{
                donationImage.setBackgroundResource(R.drawable.donation_3_banner)
                donationIconImage.setBackgroundResource(R.drawable.donation_energy)
                donationTitleText.text = "에너지 빈곤층을 위한 기부"
                donationExplainText.text = "별다른 생각 없이 쓰는 에너지, 그러나 우리 주위에는 에너지가 없어 생활의 불편함을 겪고 있는 이웃들이 있습니다.\r\n" +
                        "작은 방 하나를 데울 수 없고, 좁은 공간조차 밝힐 수 없는 이웃에게 따뜻한 에너지를 전해주세요.\r\n" +
                        "우리들의 작은 배려로 아낀 에너지가 에너지 빈곤층에게 큰 도움이 됩니다.\r\n" +
                        "시민들의 기부는 태양광에너지 설치, 주거에너지효율화, 에너지효율 제품 지원 등에 쓰입니다.\r\n" +
                        "서울에너지복지시민기금은 에너지 나눔을 실천합니다."
                donationExplainText.movementMethod = ScrollingMovementMethod()
                url = "http://www.seoulenergyfund.or.kr/"
                org_idx = 3
                org_name = "서울에너지복지시민기금"
            }
        }

        donationSpinner.adapter = spinnerAdapter
        donationSpinner.setSelection(0)

        donationDetailButton.setOnClickListener { v: View? ->
            //사이트 이동
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        donationDonateButton.setOnClickListener { v: View? ->
            //기부하기
            if(donationSpinner.selectedItemPosition == 0){
                Toast.makeText(activity,"기부금액을 선택해주세요.",Toast.LENGTH_LONG).show()
            } else { //통신
                donation_mileage = donationSpinner.selectedItemPosition * 10000
                val donationResponse = networkService.postDation(org_idx,org_name!!,user_idx,donation_mileage)
                donationResponse.enqueue(object : Callback<BaseModel>{
                    override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                        if(response!!.isSuccessful){
                            var intent = Intent(activity,DonationCompleteActivity::class.java)
                            startActivity(intent)
                        } else if(response!!.code() == 400){
                            if(response!!.body()!!.message!!.equals("The user's mileage is insufficient")){
                                Toast.makeText(activity,"마일리지가 모자랍니다.",Toast.LENGTH_LONG).show()
                            }
                        } else {

                        }
                    }

                })
            }
        }

        return view
    }

    fun init(view : View){
        donationImage = view.findViewById(R.id.donation_image)
        donationDetailButton = view.findViewById(R.id.donation_image_detail_button)
        donationIconImage = view.findViewById(R.id.donation_icon_image)
        donationTitleText = view.findViewById(R.id.donation_title_text)
        donationExplainText = view.findViewById(R.id.donation_explain_text)
        donationSpinner = view.findViewById(R.id.donation_cost_spinner)
        donationDonateButton = view.findViewById(R.id.donation_donate_button)
    }
}