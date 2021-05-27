package com.example.phonenumbertracker.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlinprcatice.Compass
import com.example.kotlinprcatice.Compass.CompassListener
import com.example.kotlinprcatice.SOTWFormatter
import com.example.phonenumbertracker.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import java.io.IOException
import java.util.*


class CompassActivity : AppCompatActivity() {
    private var compass: Compass? = null
    private var arrowView: ImageView? = null
    var supportMapFragment: SupportMapFragment? = null
    var client: FusedLocationProviderClient? = null
    private var sotwLabel // SOTW is for "side of the world"
            : TextView? = null
    private var txtCompAddres: TextView? = null
    private var currentAzimuth = 0f
    private var sotwFormatter: SOTWFormatter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compass)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        toolbar.setNavigationOnClickListener(View.OnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))

        supportMapFragment =
            supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment?

        client = LocationServices.getFusedLocationProviderClient(this)

        sotwFormatter = SOTWFormatter(this)
        arrowView = findViewById(R.id.hands)
        sotwLabel = findViewById(R.id.sotw_label)
        txtCompAddres = findViewById(R.id.address)
        setupCompass()

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        val task: Task<Location> =
            client!!.getLastLocation()
        task.addOnSuccessListener { location ->
            if (location != null) {
                val geocoder = Geocoder(this, Locale.getDefault())
                var adresess: List<Address>? = null
                var ad: Address? = null
                try {
                    adresess = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                    setAddress(adresess!![0])

                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "start compass")
        compass!!.start()
    }

    override fun onPause() {
        super.onPause()
        compass!!.stop()
    }

    override fun onResume() {
        super.onResume()
        compass!!.start()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "stop compass")
        compass!!.stop()
    }

    private fun setupCompass() {
        compass = Compass(this)
        val cl = compassListener
        compass!!.setListener(cl)
    }

    private fun adjustArrow(azimuth: Float) {
        Log.d(
            TAG, "will set rotation from " + currentAzimuth + " to "
                    + azimuth
        )
        val an: Animation = RotateAnimation(
            -currentAzimuth, -azimuth,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f
        )
        currentAzimuth = azimuth
        an.duration = 500
        an.repeatCount = 0
        an.fillAfter = true
        arrowView!!.startAnimation(an)
    }

    private fun adjustSotwLabel(azimuth: Float) {
        sotwLabel?.setText(sotwFormatter?.format(azimuth))
    }

    // UI updates only in UI thread
    // https://stackoverflow.com/q/11140285/444966
    private val compassListener: CompassListener
        private get() = object : CompassListener {
            override fun onNewAzimuth(azimuth: Float) {
                // UI updates only in UI thread
                // https://stackoverflow.com/q/11140285/444966
                runOnUiThread {
                    adjustArrow(azimuth)
                    adjustSotwLabel(azimuth)
                }
            }
        }

    companion object {
        private const val TAG = "CompassActivity"
    }

    private fun getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        val task: Task<Location> =
            client!!.getLastLocation()
        task.addOnSuccessListener { location ->
            if (location != null) {
                val geocoder = Geocoder(this, Locale.getDefault())
                var adresess: List<Address>? = null
                var ad: Address? = null
                try {
                    adresess = geocoder.getFromLocation(location.latitude, location.longitude, 1)

                } catch (e: IOException) {
                    e.printStackTrace()
                }

                supportMapFragment?.getMapAsync(OnMapReadyCallback { googleMap ->
                    val lating =
                        LatLng(location.latitude, location.longitude)
                    val options =
                        MarkerOptions().position(lating).title("See below the current address")

                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lating, 10f))
                    googleMap.addMarker(options)




                    setAddress(adresess!![0])
                })
            }
        }
    }

    private fun setAddress(adresess: Address) {

        if (adresess != null) {
            if (adresess.getAddressLine(0) != null) {
                txtCompAddres!!.setText(adresess.getAddressLine(0))
            }
            if (adresess.getAddressLine(1) != null) {
                txtCompAddres!!.setText(txtCompAddres!!.text.toString() + adresess.getAddressLine(1))
            }
        }

    }
}

