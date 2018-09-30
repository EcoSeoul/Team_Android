package com.eco.ecoseoul.home.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.eco.ecoseoul.R
import com.eco.ecoseoul.RegistrationActivity

/**
 * Created by minhyoung on 2018. 9. 28..
 */
class CardRegiDialog(context: Context) : Dialog(context),View.OnClickListener {
    override fun onClick(v: View?) {
        var intent : Intent
        intent = Intent(context,RegistrationActivity::class.java)
        context.startActivity(intent)
        dismiss()
    }

    lateinit var registButton : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_ecomoney)

        registButton = findViewById(R.id.dialog_ecomoney_button)
        registButton.setOnClickListener(this)
    }
}