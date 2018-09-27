package com.eco.ecoseoul.home.view

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.eco.ecoseoul.MainActivity
import com.eco.ecoseoul.R
import com.eco.ecoseoul.home.control.UsageAdapter
import com.eco.ecoseoul.home.model.AllUsageItem
import com.github.mikephil.charting.charts.LineChart
import java.text.SimpleDateFormat
import java.util.*
import com.eco.ecoseoul.home.model.usageItem
import kotlin.collections.ArrayList

class AllActivity : AppCompatActivity() {

    lateinit var closeButton : ImageButton
    lateinit var lineChart : LineChart

    lateinit var carbonDateText : TextView
    lateinit var carbonUsageText : TextView
    lateinit var carbonArrowImage : ImageView
    lateinit var carbonPercentageText : TextView

    lateinit var usageRecycler : RecyclerView
    lateinit var usageAdapter : UsageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all)

//        lineChart = findViewById(R.id.all_whole_lineChart)
//
//        var entries = ArrayList<Entry>()
//        entries.add(Entry(8f,20f))
//        entries.add(Entry(9f,15f))
//        entries.add(Entry(10f,12f))
//        entries.add(Entry(11f,18f))
//        entries.add(Entry(12f,22f))
//
//        var dataSet = LineDataSet(entries,"Label")
//        dataSet.setDrawFilled(true)
//        dataSet.setFillDrawable(ContextCompat.getDrawable(this,R.drawable.fade_green))
//
//        var lineData = LineData(dataSet)
//        lineChart.setData(lineData)
//        lineChart.setBackgroundColor(Color.TRANSPARENT)
//        lineChart.setDrawGridBackground(false)
//
//        lineChart.getAxisLeft().setEnabled(false);
//        lineChart.getAxisRight().setDrawAxisLine(false);
//        lineChart.getAxisRight().setDrawGridLines(false);
//        lineChart.getXAxis().setDrawAxisLine(false);
//        lineChart.getXAxis().setDrawGridLines(false);
//
//        lineChart.invalidate()

        init()

        var context = MainActivity.mContext as MainActivity
        var mainData = context.getData()

        var calendar = Calendar.getInstance()
        var tempCalendar = Calendar.getInstance()
        tempCalendar.add(Calendar.MONTH,-1)

        carbonDateText.text = calendar.get(Calendar.YEAR).toString()+"."+mainData!!.body()!!.term[0].toString()+
                " ~ "+SimpleDateFormat("YYYY.MM").format(tempCalendar.time)

        carbonUsageText.text = (mainData!!.body()!!.usageData.carbon.present.toString()+"kgCO2")

        when(mainData!!.body()!!.usageData.carbon.up_down){
            0->{
                carbonArrowImage.setBackgroundResource(R.drawable.percentage_down)
            }
            1->{
                carbonArrowImage.setBackgroundResource(R.drawable.percentage_up)
                carbonPercentageText.setTextColor(Color.parseColor("#FF8888"))
            }
            2->{
                carbonArrowImage.setBackgroundResource(R.drawable.percentage_down)
            }
        }

        carbonPercentageText.text = (mainData!!.body()!!.usageData.carbon.percentage.toString()+"%")



        var allUsageItems : ArrayList<AllUsageItem> = ArrayList()

        allUsageItems!!.add(AllUsageItem(resources.getDrawable(R.drawable.home_all_electric),calendar.get(Calendar.MONTH).toString()+"월 전기 사용량",
                mainData!!.body()!!.usageData.elec.up_down,(mainData!!.body()!!.usageData.elec.present.toString()+"kWh"),
                (mainData!!.body()!!.usageData.elec.percentage.toString()+"%")))
        allUsageItems!!.add(AllUsageItem(resources.getDrawable(R.drawable.home_all_water),calendar.get(Calendar.MONTH).toString()+"월 수도 사용량",
                mainData!!.body()!!.usageData.water.up_down,(mainData!!.body()!!.usageData.water.present.toString()+"kWh"),
                ( mainData!!.body()!!.usageData.water.percentage.toString()+"%")))
        allUsageItems!!.add(AllUsageItem(resources.getDrawable(R.drawable.home_all_gas),calendar.get(Calendar.MONTH).toString()+"월 도시가스 사용량",
                mainData!!.body()!!.usageData.gas.up_down,(mainData!!.body()!!.usageData.gas.present.toString()+"kWh"),
                (mainData!!.body()!!.usageData.gas.percentage.toString()+"%")))
        usageAdapter = UsageAdapter(allUsageItems!!)
        usageRecycler = findViewById(R.id.all_recyclerView)
        usageRecycler.adapter = usageAdapter
        usageRecycler.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)

        closeButton = findViewById(R.id.all_close_button)
        closeButton.setOnClickListener { v: View? ->
            finish()
        }

    }

    fun init(){
        carbonDateText = findViewById(R.id.all_date_text)
        carbonUsageText = findViewById(R.id.all_whole_usage_text)
        carbonArrowImage = findViewById(R.id.all_arrow_image)
        carbonPercentageText = findViewById(R.id.all_percentage_text)
    }
}
