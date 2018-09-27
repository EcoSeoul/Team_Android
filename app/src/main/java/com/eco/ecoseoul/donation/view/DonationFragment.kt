package com.eco.ecoseoul.donation.view

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.BaseModel
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R
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

        networkService = ApplicationController!!.instance.networkService


        var spinnerAdapter = DonationSpinnerAdapter(activity,spinnerList,donationDonateButton)

        when(arguments.getInt("donation")){
            0->{
                donationImage.setBackgroundResource(R.drawable.donation_1_banner)
                donationIconImage.setBackgroundResource(R.drawable.donation_tree)
                donationTitleText.text = "사막화 방지를 위한 나무 기부"
                url = "http://www.greenasia.kr/"
                org_idx = 0
                org_name = "푸른아시아"
            }

            1->{
                donationImage.setBackgroundResource(R.drawable.donation_2_banner)
                donationIconImage.setBackgroundResource(R.drawable.donation_tree)
                donationTitleText.text = "사막화 방지를 위한 나무 기부"
                url = "http://www.futureforest.org/"
                org_idx = 1
                org_name = "미래숲"
            }

            2->{
                donationImage.setBackgroundResource(R.drawable.donation_3_banner)
                donationIconImage.setBackgroundResource(R.drawable.donation_energy)
                donationTitleText.text = "에너지 빈곤층을 위한 기부"
                url = "http://www.seoulenergyfund.or.kr/"
                org_idx = 2
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
//                val donationResponse = networkService.postDation(org_idx,org_name!!,user_idx,donation_mileage)
//                donationResponse.enqueue(object : Callback<BaseModel>{
//                    override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {
//
//                    }
//
//                    override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
//                        if(response!!.isSuccessful){
//                            var intent = Intent()
//                            startActivity(intent)
//                        } else if(response!!.code() == 400){
//
//                        } else {
//
//                        }
//                    }
//
//                })
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