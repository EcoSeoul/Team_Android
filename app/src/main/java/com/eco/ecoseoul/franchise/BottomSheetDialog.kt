package com.eco.ecoseoul.franchise

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.eco.ecoseoul.R

class BottomSheetDialog: BottomSheetDialogFragment(), View.OnClickListener {
    private var tv_fran_name: TextView? = null
    private var tv_fran_type: TextView? = null
    private var tv_fran_addr: TextView? = null
    private var tv_fran_num: TextView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.bottsheet_maps, container, false)

        tv_fran_name = view.findViewById<View>(R.id.tv_fran_name) as TextView
        tv_fran_type = view.findViewById<View>(R.id.tv_fran_type) as TextView
        tv_fran_addr = view.findViewById<View>(R.id.tv_fran_addr) as TextView
        tv_fran_num = view.findViewById<View>(R.id.tv_fran_num) as TextView

        return view
    }

    override fun onClick(view: View) {

    }

    companion object {

        val instance: BottomSheetDialog
            get() = BottomSheetDialog()
    }
}