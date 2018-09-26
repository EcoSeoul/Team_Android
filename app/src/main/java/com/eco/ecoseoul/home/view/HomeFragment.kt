package com.eco.ecoseoul.home.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.eco.ecoseoul.MainActivity
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.model.MainResponse
import retrofit2.Response

/**
 * Created by minhyoung on 2018. 9. 16..
 */
class HomeFragment : Fragment() {

    lateinit var moveMainButton : ImageButton
    lateinit var detailButton : ImageButton
    lateinit var carbonText : TextView
    lateinit var carbonDate : TextView
    lateinit var reductionImage : ImageView
    lateinit var reductionText : TextView
    lateinit var saveText : TextView
    lateinit var saveMentText : TextView
    lateinit var milageProgress : ProgressBar
    var mainData : Response<MainResponse>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home,container,false)

        init(view)
        var context = activity as MainActivity
        mainData = context.getData()

        moveMainButton.setOnClickListener { v: View? ->
            var context = activity as MainActivity
            context.changePage()
        }

        detailButton.setOnClickListener { v: View? ->
            var intent = Intent(activity.applicationContext, AllActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    fun init(view : View){
        carbonText = view.findViewById(R.id.home_carborn_text)
        carbonDate = view.findViewById(R.id.home_date_text)
        reductionImage = view.findViewById(R.id.home_arrow_image)
        reductionText = view.findViewById(R.id.home_percentage_text)
        saveText = view.findViewById(R.id.home_save_text)
        saveMentText = view.findViewById(R.id.home_save_ment_text)
        moveMainButton = view.findViewById(R.id.home_toBottom_arrow_button)
        detailButton = view.findViewById(R.id.home_detail_button)
        milageProgress = view.findViewById(R.id.home_progress)

    }
}