package com.eco.ecoseoul

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.BottomSheetDialogFragment
import android.widget.LinearLayout

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in seoul and move the camera
        val seoul = LatLng(37.581982, 127.054705)
        val selectedMarker = mMap.addMarker(MarkerOptions().position(seoul).title("Marker in Seoul").icon(BitmapDescriptorFactory.fromResource(R.drawable.map_small_green_mark)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.toFloat()))
        mMap.setOnMarkerClickListener(GoogleMap.OnMarkerClickListener { marker ->

            selectedMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_big_green_mark))

            /*val bottomSheetDialog = BottomSheetDialog(this, )
            bottomSheetDialog.show(supportFragmentManager, "bottomSheet")
*/
            true
        })
        mMap.setOnMapClickListener(GoogleMap.OnMapClickListener { marker ->

            if (selectedMarker != null)
                selectedMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.map_small_green_mark))
        })
    }

}
