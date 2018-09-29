package com.eco.ecoseoul.home.view

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.eco.ecoseoul.R

/**
 * Created by minhyoung on 2018. 9. 28..
 */
class BarcodeDialog(context : Context,var barcodeBitmap: Bitmap,var mileage : Int,var name : String) : Dialog(context){

    lateinit var nameText : TextView
    lateinit var mileageText : TextView
    lateinit var barcodeImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_barcode)

        nameText = findViewById(R.id.dialog_barcode_name_text)
        mileageText = findViewById(R.id.dialog_barcode_mileage_text)
        barcodeImage = findViewById(R.id.dialog_barcode_image)

        nameText.text = name+"님 에코머니"
        mileageText.text = ""+mileage+" P"
        barcodeImage.setImageBitmap(barcodeBitmap)


    }
}