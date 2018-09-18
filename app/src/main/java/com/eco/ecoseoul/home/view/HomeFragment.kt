package com.eco.ecoseoul.home.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.eco.ecoseoul.R

/**
 * Created by minhyoung on 2018. 9. 16..
 */
class HomeFragment : Fragment() {
    lateinit var detailButton : ImageButton
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home,container,false)

        detailButton = view.findViewById(R.id.home_detail_button)
        detailButton.setOnClickListener { v: View? ->
            var intent = Intent(activity.applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}