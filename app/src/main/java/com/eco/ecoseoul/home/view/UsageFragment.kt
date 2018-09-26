package com.eco.ecoseoul.home.view

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gelitenight.waveview.library.WaveView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.eco.ecoseoul.MainActivity
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.control.WaveHelper


/**
 * Created by minhyoung on 2018. 9. 17..
 */
class UsageFragment() : Fragment() {

    //private lateinit var waveView : WaveLoadingView
    lateinit var waveViewCurrent : WaveView
    lateinit var waveViewPast : WaveView
    lateinit var mWaveHelper : WaveHelper
    lateinit var mWaveHelperPast : WaveHelper
    lateinit var detailButton : ImageButton
    lateinit var dateText : TextView
    lateinit var whatText : TextView
    lateinit var quantityText : TextView
    lateinit var arrowImage : ImageView
    lateinit var percentageText : TextView
    lateinit var saveText : TextView
    lateinit var toBottButton : ImageButton
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_usage,container,false)
        initView(view)
        waveViewCurrent = view.findViewById(R.id.waveViewCurrent)
        waveViewCurrent.setShapeType(WaveView.ShapeType.SQUARE)
        mWaveHelper = WaveHelper(waveViewCurrent)

        waveViewPast = view.findViewById(R.id.waveViewPast)
        waveViewPast.setShapeType(WaveView.ShapeType.SQUARE)
        mWaveHelperPast = WaveHelper(waveViewPast)
        when(arguments.getInt("usage")){
            1->{//전기
                dateText.text = "8월"
                whatText.text = "전기 사용량"
                quantityText.text = "1000kWh"
                arrowImage.setImageResource(R.drawable.percentage_down)
                percentageText.text = "10%"
                saveText.text = "작년보다 70%를"
                waveViewCurrent.setWaveColor(Color.parseColor("#00000000"),Color.parseColor("#FADE43"))
                mWaveHelper.initWave(0.3f)

                waveViewPast.setWaveColor(Color.parseColor("#00000000"),Color.parseColor("#F5F5F5"))
                mWaveHelperPast.initWave(0.5f)
            }
            2->{//수도
                dateText.text = "8월"
                whatText.text = "수도 사용량"
                quantityText.text = "1200kWh"
                arrowImage.setImageResource(R.drawable.percentage_down)
                percentageText.text = "10%"
                saveText.text = "작년보다 30%를"
                waveViewCurrent.setWaveColor(Color.parseColor("#00000000"),Color.parseColor("#4486F0"))
                mWaveHelper.initWave(0.7f)

                waveViewPast.setWaveColor(Color.parseColor("#00000000"),Color.parseColor("#F5F5F5"))
                mWaveHelperPast.initWave(0.5f)
            }
            3->{//도시가스
                dateText.text = "8월"
                whatText.text = "도시가스 사용량"
                quantityText.text = "900kWh"
                arrowImage.setImageResource(R.drawable.percentage_down)
                percentageText.text = "10%"
                saveText.text = "작년보다 50%를"
                waveViewCurrent.setWaveColor(Color.parseColor("#00000000"),Color.parseColor("#D5B1FF"))
                mWaveHelper.initWave(0.5f)

                waveViewPast.setWaveColor(Color.parseColor("#00000000"),Color.parseColor("#F5F5F5"))
                mWaveHelperPast.initWave(0.8f)
            }
        }
        mWaveHelperPast.startWave()
        mWaveHelper.startWave()

        toBottButton.setOnClickListener { v: View? ->
            var context = activity as MainActivity
            context.changePage()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        mWaveHelper.startWave()
    }

    override fun onPause() {
        super.onPause()
        mWaveHelper.cancelWave()
    }

    fun initView(view :View){
        detailButton = view.findViewById(R.id.usage_detail_button)
        dateText = view.findViewById(R.id.usage_date_text)
        whatText = view.findViewById(R.id.usage_what_text)
        quantityText = view.findViewById(R.id.usage_quantity_text)
        arrowImage = view.findViewById(R.id.usage_arrow_image)
        percentageText = view.findViewById(R.id.usage_percentage_text)
        saveText = view.findViewById(R.id.usage_save_text)
        toBottButton = view.findViewById(R.id.usage_toBottom_arrow_button)

    }
}