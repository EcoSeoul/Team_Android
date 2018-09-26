package com.eco.ecoseoul.community

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.eco.ecoseoul.R
import com.eco.ecoseoul.community.CommunityWriteActivity
import kotlinx.android.synthetic.main.activity_community.*

class CommunityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)

        com_write_btn.setOnClickListener {
            val intent = Intent(this, CommunityWriteActivity::class.java)
            startActivity(intent)
        }
    }
}
