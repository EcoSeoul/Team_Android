package com.eco.ecoseoul.home.view

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageButton
import com.eco.ecoseoul.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class AllActivity : AppCompatActivity() {

    lateinit var closeButton : ImageButton
    lateinit var lineChart : LineChart

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

        closeButton = findViewById(R.id.all_close_button)
        closeButton.setOnClickListener { v: View? ->
            finish()
        }

    }
}
