package com.eco.ecoseoul.franchise

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.R

import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class BottomSheetDialog() : BottomSheetDialogFragment(), View.OnClickListener {

    private var tv_fran_name: TextView? = null
    private var tv_fran_type: TextView? = null
    private var tv_fran_addr: TextView? = null
    private var tv_fran_num: TextView? = null
    lateinit var networkService : NetworkService
     var frc_idx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("boottttttom","oncreateonasdjnkasd")
        frc_idx = arguments!!.getInt("frc_index")
        Log.d("asdfkasdkfjl",""+frc_idx)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.bottsheet_maps, container, false)
        Log.d("boottttom",""+frc_idx)
        var frcInfo = frc_idx;
        networkService = ApplicationController.instance!!.networkService
        tv_fran_name = view.findViewById<View>(R.id.tv_fran_name) as TextView
        tv_fran_type = view.findViewById<View>(R.id.tv_fran_type) as TextView
        tv_fran_addr = view.findViewById<View>(R.id.tv_fran_addr) as TextView
        tv_fran_num = view.findViewById<View>(R.id.tv_fran_num) as TextView

        val mapsResponse = networkService.getFranInfo(frcInfo)
        mapsResponse.enqueue(object : retrofit2.Callback<MapsResponse>{
            override fun onFailure(call: Call<MapsResponse>, t: Throwable) {
                Log.d("getFranInfo: ", "fail")
            }

            override fun onResponse(call: Call<MapsResponse>, response: Response<MapsResponse>) {
                tv_fran_name!!.text = response!!.body()!!.frc_information[0].frc_name
                tv_fran_type!!.text = response!!.body()!!.frc_information[0].frc_type.toString()
                tv_fran_num!!.text = response!!.body()!!.frc_information[0].frc_phone
                tv_fran_addr!!.text = response!!.body()!!.frc_information[0].frc_add
            }

        })

        return view
    }

    override fun onClick(view: View) {

    }

    companion object {

        lateinit var instance : BottomSheetDialog
    }
}