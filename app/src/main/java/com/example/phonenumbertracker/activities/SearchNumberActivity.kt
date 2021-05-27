package com.example.phonenumbertracker.activities

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.net.ConnectivityManager
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.databinding.ActivitySearchNumberBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import com.hbb20.CountryCodePicker
import java.io.IOException
import java.util.*


class SearchNumberActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener,
    GoogleMap.OnCameraMoveListener,
    GoogleMap.OnCameraMoveStartedListener, GoogleMap.OnCameraIdleListener {
    var supportMapFragment: SupportMapFragment? = null
    var client: FusedLocationProviderClient? = null
    lateinit var tvCurrentAddress: TextView
    private var mMap: GoogleMap? = null
    private final var context: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivitySearchNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var toolbar = findViewById<Toolbar>(R.id.toolBarDesign)
        setSupportActionBar(toolbar)

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))

        val textView: CountryCodePicker = findViewById(R.id.spinner) as CountryCodePicker

        context = findViewById(R.id.myMap)

        supportMapFragment =
            supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment?

        client = LocationServices.getFusedLocationProviderClient(this)


        //mMap = supportMapFragment.Map()
        supportMapFragment!!.getView()?.setVisibility(View.INVISIBLE)



        binding.txtSearch.setOnClickListener {
            var selected_country_code = textView.selectedCountryName
            var countryCode = textView.selectedCountryCode
            /*if (binding.edtPhone.text.toString().trim().equals("")) {
                Toast.makeText(this, "Please enter number first", Toast.LENGTH_LONG).show()
            } else {
                getCurrentLocation()
            }*/

            if (countryCode.length > 0 && binding.edtPhone.text.toString().trim().length > 0) {
                if (isValidPhoneNumber(binding.edtPhone.text.toString().trim())) {
                    val status = validateUsing_libphonenumber(
                        countryCode,
                        binding.edtPhone.text.toString().trim()
                    )
                    if ((status && isNetworkConnected()) || (status && internetIsConnected())) {
                        //Toast.makeText(this,selected_country_code,Toast.LENGTH_LONG).show()
                        supportMapFragment!!.getView()?.setVisibility(View.VISIBLE)
                        // tvIsValidPhone.setText("Valid Phone Number (libphonenumber)")
                        //Toast.makeText(this,"Valid Phone Number",Toast.LENGTH_LONG).show()
                        getCurrentLocation()

                    } else {

                        //tvIsValidPhone.setText("Invalid Phone Number (libphonenumber)")
                        Toast.makeText(this,"Internet not connected",Toast.LENGTH_LONG).show()
                        //binding.edtPhone.setText("")
                    }
                } else {
                    // tvIsValidPhone.setText("Invalid Phone Number (isValidPhoneNumber)")
                    Toast.makeText(
                        this,
                        "Invalid Phone Number (isValidPhoneNumber)",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(applicationContext, "Phone Number is required", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        textView.setOnCountryChangeListener(CountryCodePicker.OnCountryChangeListener { //Alert.showMessage(RegistrationActivity.this, ccp.getSelectedCountryCodeWithPlus());

        })


        //tvCurrentAddress = findViewById<TextView>(R.id.txtAddress)

        if (ActivityCompat.checkSelfPermission(
                this@SearchNumberActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // getCurrentLocation()
        } else {
            ActivityCompat.requestPermissions(
                this@SearchNumberActivity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                44
            )
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
                    val textView: CountryCodePicker =
                        findViewById(R.id.spinner) as CountryCodePicker
                    var selected_country_code = textView.selectedCountryName
                    if (selected_country_code.equals("pakistan"))
                        adresess = geocoder.getFromLocation(33.66839145313031, 73.0132738035078, 1)
                    else
                        adresess = geocoder.getFromLocationName(selected_country_code, 1)

                    Log.e("Tag", "Data" + selected_country_code)

                } catch (e: IOException) {
                    e.printStackTrace()
                }

                supportMapFragment?.getMapAsync(OnMapReadyCallback { googleMap ->
                    if (adresess!=null)
                    {
                        val location: Address = adresess!!.get(0)

                        var a = location.latitude
                        var b = location.longitude

                        val lating = LatLng(
                            a, b
                        )
                        val textView: CountryCodePicker =
                            findViewById(R.id.spinner) as CountryCodePicker
                        var selected_country_code = textView.selectedCountryName

                        val options =
                            MarkerOptions().position(lating).title(selected_country_code)

                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lating, 5f))
                        googleMap.addMarker(options)



                        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
                        //googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        // googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        //googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        //googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

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
                        //googleMap.getUiSettings().setZoomGesturesEnabled(true)


                        //setAddress(adresess!![0])
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

        //setAddress(adresess!![0])

    }

    /*
    private fun setAddress(adresess: Address) {

        if (adresess!=null)
        {
            if (adresess.getAddressLine(0)!=null){
                tvCurrentAddress!!.setText(adresess.getAddressLine(0))
            }
            if (adresess.getAddressLine(1)!=null)
            {
                tvCurrentAddress!!.setText(tvCurrentAddress.text.toString() + adresess.getAddressLine(1))
            }
        }

    }*/

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

        //setAddress(adresess!![0])
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

    private fun isValidPhoneNumber(phoneNumber: CharSequence): Boolean {
        return if (!TextUtils.isEmpty(phoneNumber)) {
            Patterns.PHONE.matcher(phoneNumber).matches()
        } else false
    }

    private fun validateUsing_libphonenumber(countryCode: String, phNumber: String): Boolean {
        val phoneNumberUtil: PhoneNumberUtil = PhoneNumberUtil.getInstance()
        val isoCode: String = phoneNumberUtil.getRegionCodeForCountryCode(countryCode.toInt())
        var phoneNumber: Phonenumber.PhoneNumber? = null
        try {
            //phoneNumber = phoneNumberUtil.parse(phNumber, "IN");  //if you want to pass region code
            phoneNumber = phoneNumberUtil.parse(phNumber, isoCode)
        } catch (e: NumberParseException) {
            System.err.println(e)
        }
        val isValid: Boolean = phoneNumberUtil.isValidNumber(phoneNumber)
        return if (isValid) {
            val internationalFormat: String = phoneNumberUtil.format(
                phoneNumber,
                PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL
            )
            //Toast.makeText(this, "Phone Number is Valid $internationalFormat", Toast.LENGTH_LONG)
               // .show()
            true
        } else {
            Toast.makeText(this, "Phone Number is Invalid $phoneNumber", Toast.LENGTH_LONG).show()
            false
        }
    }

}