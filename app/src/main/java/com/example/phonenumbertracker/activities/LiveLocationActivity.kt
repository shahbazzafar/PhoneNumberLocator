package com.example.phonenumbertracker.activities

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.phonenumbertracker.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import java.io.IOException
import java.util.*

class LiveLocationActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener,
    GoogleMap.OnCameraMoveListener,
    GoogleMap.OnCameraMoveStartedListener, GoogleMap.OnCameraIdleListener {

    var supportMapFragment: SupportMapFragment? = null
    var client: FusedLocationProviderClient? = null
    lateinit var tvCurrentAddress: TextView
    private var mMap: GoogleMap? = null
    private final var context: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_location)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        // setSupportActionBar(toolbar)

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))


        context = findViewById(R.id.myMap)

        supportMapFragment =
            supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment?

        client = LocationServices.getFusedLocationProviderClient(this)
        tvCurrentAddress = findViewById<TextView>(R.id.txtAddress)

        if (ActivityCompat.checkSelfPermission(
                this@LiveLocationActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            if (isNetworkConnected() || internetIsConnected())
            getCurrentLocation()
            else
                Toast.makeText(this,"Internet is not connected",Toast.LENGTH_LONG).show()
        } else {
            ActivityCompat.requestPermissions(
                this@LiveLocationActivity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                44
            )
        }


        tvCurrentAddress.setOnClickListener {
            val snackbar = Snackbar.make(
                it, "Replace with your own action",
                Snackbar.LENGTH_LONG
            ).setAction("Action", null)
            snackbar.setActionTextColor(Color.BLUE)
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(Color.LTGRAY)
            //val textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            //textView.setTextColor(Color.BLUE)
            //textView.textSize = 28f
            //snackbar.show()
        }
    }

    private fun isNetworkConnected(): Boolean {
        val cm: ConnectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.getActiveNetworkInfo() != null
    }

    fun internetIsConnected(): Boolean {
        return try {
            val command = "ping -c 1 google.com"
            Runtime.getRuntime().exec(command).waitFor() == 0
        } catch (e: Exception) {
            false
        }
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
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        val task: Task<Location> =
            client!!.getLastLocation()
        task.addOnSuccessListener { location ->
            if (location != null) {
                val latitude: Double
                val longtitude: Double
                val geocoder = Geocoder(this, Locale.getDefault())
                var adresess: List<Address>? = null
                var ad: Address? = null
                try {
                    adresess = geocoder.getFromLocation(location.latitude, location.longitude, 1)


                } catch (e: IOException) {
                    e.printStackTrace()
                }

                supportMapFragment?.getMapAsync(OnMapReadyCallback { googleMap ->
                    if (adresess!=null)
                    {
                        val location: Address = adresess!!.get(0)
                        location.latitude
                        location.longitude
                        val lating =
                            LatLng(location.latitude, location.longitude)
                        val options =
                            MarkerOptions().position(lating).title("See below the current address")

                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lating, 10f))
                        googleMap.addMarker(options)


                        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
                        // googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        // googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        // googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

                        // Showing / hiding your current location
                        googleMap.setMyLocationEnabled(true)

                        // Enable / Disable zooming controls
                        googleMap.getUiSettings().setZoomControlsEnabled(true)

                        // Enable / Disable my location button
                        googleMap.getUiSettings().setMyLocationButtonEnabled(true)

                        // Enable / Disable Compass icon
                        googleMap.getUiSettings().setCompassEnabled(true)

                        // Enable / Disable Rotate gesture
                        googleMap.getUiSettings().setRotateGesturesEnabled(true)

                        // Enable / Disable zooming functionality
                        googleMap.getUiSettings().setZoomGesturesEnabled(true)






                        setAddress(adresess!![0])
                    }

                })
            }
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 44) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation()
            }
        }
    }

    override fun onLocationChanged(location: Location) {

        val geocoder = Geocoder(this, Locale.getDefault())
        var adresess: List<Address>? = null
        try {
            adresess = geocoder.getFromLocation(location.latitude, location.longitude, 1)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        setAddress(adresess!![0])

    }

    private fun setAddress(adresess: Address) {

        if (adresess != null) {
            if (adresess.getAddressLine(0) != null) {
                tvCurrentAddress!!.setText(adresess.getAddressLine(0))
            }
            if (adresess.getAddressLine(1) != null) {
                tvCurrentAddress!!.setText(
                    tvCurrentAddress.text.toString() + adresess.getAddressLine(
                        1
                    )
                )
            }
        }

    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle) {

    }

    override fun onProviderEnabled(p0: String) {

    }

    override fun onProviderDisabled(provider: String) {

    }

    override fun onCameraMove() {

    }

    override fun onCameraMoveStarted(p0: Int) {

    }

    override fun onCameraIdle() {
        val geocoder = Geocoder(this, Locale.getDefault())
        var adresess: List<Address>? = null
        try {
            adresess = geocoder.getFromLocation(
                mMap!!.cameraPosition.target.latitude,
                mMap!!.cameraPosition.target.longitude,
                1
            )
        } catch (e: IOException) {
            e.printStackTrace()
        }

        setAddress(adresess!![0])
    }

    override fun onMapReady(p0: GoogleMap?) {

        mMap = p0
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }


        mMap!!.setMyLocationEnabled(true)
        mMap!!.setOnCameraMoveListener(this)
        mMap!!.setOnCameraMoveStartedListener(this)
        mMap!!.setOnCameraIdleListener(this)

    }

}