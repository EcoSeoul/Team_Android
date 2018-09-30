package com.eco.ecoseoul

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton


class MainBanner3Activity : AppCompatActivity() {

    lateinit var banner_arrow1 : ImageButton
    lateinit var banner_arrow2 : ImageButton
    lateinit var banner_arrow3 : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_banner3)

        var url : String? = null


        banner_arrow1 = findViewById(R.id.banner_arrow1)
        banner_arrow2 = findViewById(R.id.banner_arrow2)
        banner_arrow3 = findViewById(R.id.banner_arrow3)


        banner_arrow1.setOnClickListener { v: View? ->

            url = "http://m.tbs.seoul.kr/news/newsView.do?channelCode=CH_N&seq_800=10286332&idx_800=2306506&typ_800=R&grd_800=null"

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        banner_arrow2.setOnClickListener { v: View? ->

            url = "https://m.news.naver.com/read.nhn?mode=LSD&mid=sec&sid1=102&oid=016&aid=0001445906"

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }

        banner_arrow3.setOnClickListener { v: View? ->
            url = "http://www.shinailbo.co.kr/news/articleView.html?idxno=1097422"

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }



    }
}
