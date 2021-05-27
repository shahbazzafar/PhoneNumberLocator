package com.example.phonenumbertracker.activities

import android.Manifest
import android.content.*
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.databinding.ActivityContactDetailsBinding
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
import java.io.IOException
import java.util.*


class ContactDetailsActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener,
    GoogleMap.OnCameraMoveListener,
    GoogleMap.OnCameraMoveStartedListener, GoogleMap.OnCameraIdleListener {


    private lateinit var binding: ActivityContactDetailsBinding
    var idContact = ""
    var getPhone = ""
    var getName = ""
    var mCurrentLookupKey = ""
    var mCurrentId = ""

    var supportMapFragment: SupportMapFragment? = null
    var client: FusedLocationProviderClient? = null
    lateinit var tvCurrentAddress: TextView
    private var mMap: GoogleMap? = null
    private final var context: View? = null
    var phonelocation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)



        binding.toolbar.setNavigationOnClickListener(View.OnClickListener {
            var intent = Intent(this, ContactListActivity::class.java)
            startActivity(intent)
        })


        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))

        context = findViewById(R.id.myMap)

        supportMapFragment =
            supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment?

        client = LocationServices.getFusedLocationProviderClient(this)

        getPhone = intent.extras!!.getString("uzzo").toString()
        getName = intent.extras!!.getString("phoneNumber").toString()
        binding.txtPhone.text = getPhone

        phonelocation = intent.extras!!.getString("abcd").toString()
        Log.i("ABCDEFG", "Code: $phonelocation")
        if (isNetworkConnected() || internetIsConnected())
        getCurrentLocation()
        else
            Toast.makeText(this,"Internet not connected",Toast.LENGTH_LONG).show()

        binding.imgCopy.setOnClickListener {

            binding.imgCopy.setColorFilter(
                ContextCompat.getColor(this, R.color.white),
                android.graphics.PorterDuff.Mode.MULTIPLY
            )
            Toast.makeText(this, "Copy Successfully!", Toast.LENGTH_LONG).show()
            val clipboard: ClipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("Copied", getPhone)
            clipboard.setPrimaryClip(clip)
        }

        binding.abc.linearCall.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", getPhone, null))
            startActivity(intent)
        }
        binding.abc.linearSms.setOnClickListener {
            val smsIntent = Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", getPhone, null))
            startActivity(smsIntent)
        }
        binding.abc.linearEdit.setOnClickListener {
            /*var  mSelectedContactUri = Uri.fromParts("det",getPhone,null)
            val uri: Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
            val cursor: Cursor? = applicationContext.contentResolver.query(
                uri,
                null,
                null,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME.toString() + " ASC"
            )
            while (cursor!!.moveToNext()) {
                idContact =
                    cursor!!.getLong(cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID))
                        .toString()
            }
            val i = Intent(Intent.ACTION_EDIT)
            val contactUri: Uri =
                ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, idContact.toLong())
            i.data = contactUri
           //i.setDataAndType(mSelectedContactUri, ContactsContract.Contacts.CONTENT_ITEM_TYPE)
            i.setData(mSelectedContactUri)
           //i.putExtra("finishActivityOnSaveCompleted", true)
            startActivity(i)*/
            //editContact(getPhone)
            val contact = "+00 9876543210" // use country code with your phone number

            val url = "https://api.whatsapp.com/send?phone=$getPhone"
            try {

                val pm: PackageManager = this.getPackageManager()
                pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            } catch (e: PackageManager.NameNotFoundException) {
                Toast.makeText(
                    this,
                    "Whatsapp app not installed in your phone",
                    Toast.LENGTH_SHORT
                ).show()
                e.printStackTrace()
            }

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

    override fun onBackPressed() {
        var intent = Intent(this, ContactListActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }

    fun editContact(num: String) {
        var lookUp =
            Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(num))
        var mcursor = contentResolver.query(lookUp, null, null, null, num)
        var idphone = 0
        try {
            if (mcursor!!.moveToFirst()) {
                idphone =
                    mcursor.getString(mcursor.getColumnIndex(ContactsContract.PhoneLookup._ID))
                        .toLong()
                        .toInt()
                var editcontact = Intent(Intent.ACTION_EDIT)
                editcontact.setData(
                    ContentUris.withAppendedId(
                        ContactsContract.Contacts.CONTENT_URI,
                        idphone.toLong()
                    )
                )
                startActivity(editcontact)
            } else
                Toast.makeText(this, "Contact not found", Toast.LENGTH_LONG).show()

        } finally {
            mcursor!!.close()
        }

    }

    //testing
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
                    //val textView : CountryCodePicker = findViewById(R.id.spinner) as CountryCodePicker


                    val loc = Locale("", phonelocation)
                    val country = loc.displayCountry

                    binding.abc.txtName.text = getName
                    binding.abc.txtCity.text = "Location: " + country
                    if (country.equals("pakistan"))
                        adresess = geocoder.getFromLocation(33.66839145313031, 73.0132738035078, 1)
                    else
                        adresess = geocoder.getFromLocationName(country, 1)


                } catch (e: IOException) {
                    e.printStackTrace()
                }

                supportMapFragment?.getMapAsync(OnMapReadyCallback { googleMap ->
                    if(adresess!=null)
                    {
                        val location: Address = adresess!!.get(0)


                        var a = location.latitude
                        var b = location.longitude

                        val lating = LatLng(
                            a, b
                        )
                        val loc = Locale("", phonelocation)
                        val country = loc.displayCountry

                        val options =
                            MarkerOptions().position(lating).title(country)

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
            Toast.makeText(this, "Phone Number is Valid $internationalFormat", Toast.LENGTH_LONG)
                .show()
            true
        } else {
            Toast.makeText(this, "Phone Number is Invalid $phoneNumber", Toast.LENGTH_LONG).show()
            false
        }
    }


}