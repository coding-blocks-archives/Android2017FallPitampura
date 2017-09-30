package com.codingblocks.locations

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

import android.Manifest.permission.*
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log

class MainActivity : AppCompatActivity(), LocationListener {
    companion object {
        val TAG = "LOC"
    }
    override fun onLocationChanged(loc: Location?) {
        Log.d(TAG, "latitude = ${loc?.latitude}")
        Log.d(TAG, "longitude = ${loc?.longitude}")
        Log.d(TAG, " = = = = = = = = = = = = = = =  ")

    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var lm: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager


        val fileLocPerm = ContextCompat.checkSelfPermission(this,
                ACCESS_FINE_LOCATION)
        val coarseLocPerm = ContextCompat.checkSelfPermission(this,
                ACCESS_COARSE_LOCATION)

        if (fileLocPerm != PackageManager.PERMISSION_GRANTED ||
                coarseLocPerm != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf(ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION),
                    111
            )
        } else {
            startLocUpates()
        }
    }

    fun startLocUpates () {
        lm.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                1000,
                100f,
                this
        )

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        if (requestCode == 111) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                startLocUpates()
            }
        }



        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
