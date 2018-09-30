package com.eco.ecoseoul.home.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.eco.ecoseoul.ApplicationController
import com.eco.ecoseoul.MainActivity
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.control.ProgressBarAnimation
import com.eco.ecoseoul.home.model.MainResponse
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

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
    lateinit var milageProgress : ProgressBar
    var mainData : Response<MainResponse>? = null
    lateinit var circlePointList : ArrayList<ImageView>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home,container,false)

        init(view)
//        var context = activity as MainActivity
//        mainData = context.getData()

        mainData = ApplicationController!!.instance.mainItems

        var calendar = Calendar.getInstance()
        carbonDate.text = ""+mainData!!.body()!!.term[0]+"월 ~ "+calendar.get(Calendar.MONTH)+"월"
        carbonText.text = ""+mainData!!.body()!!.usageData.carbon.present+"kgCO2"
        when(mainData!!.body()!!.usageData.carbon.up_down){
            0->{
                reductionImage.setBackgroundResource(R.drawable.percentage_down)
                saveText.text = "작년과 같은 사용량 이에요!"
            }
            2->{
                reductionImage.setBackgroundResource(R.drawable.percentage_up)
                reductionText.setTextColor(Color.parseColor("#FF8888"))
                saveText.text = "작년보다 "+mainData!!.body()!!.usageData.carbon.percentage.toString()+"%를\r\n" +
                        "더 사용하셨어요..."
                milageProgress.progressDrawable = resources.getDrawable(R.drawable.circular_progress_bar_red)
            }
            2->{
                reductionImage.setBackgroundResource(R.drawable.percentage_down)
                saveText.text = "작년보다 "+mainData!!.body()!!.usageData.carbon.percentage.toString()+"%를\r\n" +
                        "절약한 당신! 최고에요!"
            }
        }
        reductionText.text = ""+mainData!!.body()!!.usageData.carbon.percentage+"%"
        //milageProgress.progress = mainData!!.body()!!.usageData.carbon.percentage

        circlePointList = ArrayList()
        var image : ImageView = view.findViewById(R.id.home_circle1)
        circlePointList.add(image)
        image = view.findViewById(R.id.home_circle2)
        circlePointList.add(image)
        image = view.findViewById(R.id.home_circle3)
        circlePointList.add(image)


        var mProgressAnimation = ProgressBarAnimation(milageProgress,circlePointList,mainData!!.body()!!.usageData.carbon.up_down,2000)
        mProgressAnimation.setProgress(mainData!!.body()!!.usageData.carbon.percentage)

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
        moveMainButton = view.findViewById(R.id.home_toBottom_arrow_button)
        detailButton = view.findViewById(R.id.home_detail_button)
        milageProgress = view.findViewById(R.id.home_progress)

    }
}