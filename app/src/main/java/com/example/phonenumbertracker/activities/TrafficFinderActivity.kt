package com.example.phonenumbertracker.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.*
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
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
import java.io.IOException
import java.util.*

class TrafficFinderActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener,
    GoogleMap.OnCameraMoveListener,
    GoogleMap.OnCameraMoveStartedListener, GoogleMap.OnCameraIdleListener {

    var supportMapFragment: SupportMapFragment? = null
    var client: FusedLocationProviderClient? = null
    lateinit var tvCurrentAddress: TextView
    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic_finder)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))


        toolbar.setNavigationOnClickListener(View.OnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })


        supportMapFragment =
            supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment?

        client = LocationServices.getFusedLocationProviderClient(this)


        if (ActivityCompat.checkSelfPermission(
                this@TrafficFinderActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            getCurrentLocation()
        } else {
            ActivityCompat.requestPermissions(
                this@TrafficFinderActivity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                44
            )
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

                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
                    // googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    // googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    // googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    // googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

                    // Showing / hiding your current location
                    googleMap.setMyLocationEnabled(true)
                    googleMap.setTrafficEnabled(true)
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