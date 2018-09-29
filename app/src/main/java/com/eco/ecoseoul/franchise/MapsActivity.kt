package com.eco.ecoseoul

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.BottomSheetDialogFragment
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.RemoteViewsService
import com.eco.ecoseoul.NetworkService.NetworkService
import com.eco.ecoseoul.franchise.FranchiseResponse
import com.eco.ecoseoul.franchise.FrcData
import com.eco.ecoseoul.franchise.MapsResponse

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    var gu_idx : Int = 0
    lateinit var networkService: NetworkService
    //lateinit var frcDataList : ArrayList<FrcData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        gu_idx = intent.extras.getInt("gu_idx")
        Log.d("MapsActivity>>", "onCreate-gu_idx" + gu_idx.toString())

        //frcDataList = ArrayList()

        networkService = ApplicationController.instance.networkService
    }

    override fun onMapReady(googleMap: GoogleMap) {

        Log.d("MapsActivity>>", "onMapReady-gu_idx" + gu_idx.toString())
        mMap = googleMap

        val mapsResponse = networkService.getFranchises(gu_idx)
        mapsResponse.enqueue(object : Callback<FranchiseResponse>{
            override fun onFailure(call: Call<FranchiseResponse>, t: Throwable) {
                Log.d("getFranInfo: ", "fail")
            }

            override fun onResponse(call: Call<FranchiseResponse>, response: Response<FranchiseResponse>) {
                if (response!!.isSuccessful) {
                    Log.d("getFranInfo:", "success")
                    var frcDataList = response!!.body()!!.data
                    Log.d("getFranInfo:", frcDataList.size.toString())

                    val gu_latlng = LatLng(frcDataList.get(0).frc_lat, frcDataList.get(0).frc_long)

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(gu_latlng))
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gu_latlng, 15.toFloat()))

                    /*when (gu_idx) {
                        1 -> {
                            val gangbook = LatLng(37.640074, 127.025454)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(gangbook))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gangbook, 15.toFloat()))
                        }
                        3 -> {
                            val seongbook = LatLng(37.589515, 127.016743)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(seongbook))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(seongbook, 15.toFloat()))
                        }
                        4 -> {
                            val no_one = LatLng(37.654324, 127.056353)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(no_one))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(no_one, 15.toFloat()))
                        }
                        5 -> {
                            val dongdaemoon = LatLng(37.582066, 127.059994)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(dongdaemoon))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dongdaemoon, 15.toFloat()))
                        }
                        6 -> {
                            val joongrang = LatLng(37.606874, 127.092635)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(joongrang))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(joongrang, 15.toFloat()))
                        }
                        7 -> {
                            val seongdong = LatLng(37.566519, 127.035923)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(seongdong))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(seongdong, 15.toFloat()))
                        }
                        8 -> {
                            val gwangjin = LatLng(37.538840, 127.082334)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(gwangjin))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gwangjin, 15.toFloat()))
                        }
                        9 -> {
                            val kangdong = LatLng(37.538840, 127.082334)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(kangdong))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kangdong, 15.toFloat()))
                        }
                        10 -> {
                            val songpa = LatLng(37.515808, 127.105873)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(songpa))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(songpa, 15.toFloat()))
                        }
                        11 -> {
                            val seocho = LatLng(37.483821, 127.032650)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(seocho))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(seocho, 15.toFloat()))
                        }
                        12 -> {
                            val kangnam = LatLng(37.517549, 127.047438)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(kangnam))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kangnam, 15.toFloat()))
                        }
                        13 -> {
                            val jongro = LatLng(37.573454, 126.979592)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(jongro))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(jongro, 15.toFloat()))
                        }
                        14 -> {
                            val joonggu = LatLng(37.563758, 126.997519)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(joonggu))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(joonggu, 15.toFloat()))
                        }
                        16 -> {
                            val dongjak = LatLng(37.512588, 126.939482)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(dongjak))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dongjak, 15.toFloat()))
                        }
                        17 -> {
                            val geumcheon = LatLng(37.478205, 126.951481) //gwanak
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(geumcheon))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(geumcheon, 15.toFloat()))
                        }
                        18 -> {
                            val kangseo = LatLng(37.550910, 126.849535)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(kangseo))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kangseo, 15.toFloat()))
                            *//*mMap.addMarker(MarkerOptions().position(kangseo).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_small_green_mark)))*//*
                        }
                        19 -> {
                            val yangcheon = LatLng(37.516993, 126.866607)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(yangcheon))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(yangcheon, 15.toFloat()))
                        }
                        20 -> {
                            val yeongdeungpo = LatLng(37.526333, 126.896219)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(yeongdeungpo))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(yeongdeungpo, 15.toFloat()))
                        }
                        21 -> {
                            val eunpyeong = LatLng(37.602869, 126.929217)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(eunpyeong))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(eunpyeong, 15.toFloat()))
                        }
                        22 -> {
                            val mapo = LatLng(37.566204, 126.901646)
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(mapo))
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mapo, 15.toFloat()))
                        }

                    }*/
                    Log.d("MapsActivity>> ", "begin loop")
                    Log.d("MapsActivity>>", "onMapReady-frcData.size: " + frcDataList.size.toString())

                    for (i in 0 ..frcDataList.size -1){
                        Log.d("MapsActivity>> ", "loop for response frcData" + i)
                        val franchise = LatLng(frcDataList.get(i).frc_lat, frcDataList.get(i).frc_long)
                        var frc_idx = frcDataList.get(i).frc_idx

                        var selectedMarker = mMap.addMarker(MarkerOptions().position(franchise).title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_small_green_mark)))
                        mMap.setOnMarkerClickListener(GoogleMap.OnMarkerClickListener { marker ->
                            selectedMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_big_green_mark))
                            newInstance(frc_idx).show()
                            true
                        })
                        mMap.setOnMapClickListener(GoogleMap.OnMapClickListener { marker ->

                            if (selectedMarker != null)
                                selectedMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_small_green_mark))
                        })
                    }
                }
            }
        })



    }

    fun newInstance(frc_index : Int): BottomSheetDialog {

        var index = frc_index

        val fragment = BottomSheetDialogFragment()
        val args = Bundle()
        args.putInt("frc_index", index)
        fragment.arguments = args

        return fragment as BottomSheetDialog
    }

}
