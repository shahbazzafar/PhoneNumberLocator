package com.example.phonenumbertracker.activities


import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.multidex.BuildConfig
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.databinding.ActivityHomeBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.shreyaspatil.MaterialDialog.BottomSheetMaterialDialog


class HomeActivity : AppCompatActivity() {

    var imgShare: ImageView? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))
        /* Dexter
             .withActivity(this@HomeActivity)
             .withPermissions(
                 Manifest.permission.ACCESS_FINE_LOCATION,
                 Manifest.permission.ACCESS_COARSE_LOCATION,
                 Manifest.permission.READ_CONTACTS
             )*/

        //chal raha ha yeah
        /* Dexter.withContext(this)
             .withPermission(
                 Manifest.permission.ACCESS_FINE_LOCATION,

             )
             .withListener(object : PermissionListener {
                 override fun onPermissionGranted(response: PermissionGrantedResponse) {
                 *//* ... *//*
                    Toast.makeText(this@HomeActivity,"PASS", Toast.LENGTH_SHORT).show()
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) { *//* ... *//*

                    Toast.makeText(this@HomeActivity,"Fail",Toast.LENGTH_SHORT).show()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest,
                    token: PermissionToken
                ) { *//* ... *//*
                }
            }).check()*/

        //yaha tak

        Dexter.withContext(this)
            .withPermissions(
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    /* ... */

                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest>,
                    token: PermissionToken
                ) { /* ... */
                }
            }).check()
        /*.withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(report: MultiplePermissionsReport?) {

            }

            override fun onPermissionRationaleShouldBeShown(permissions: MutableList<PermissionRequest>?, token: PermissionToken?) {
                //Timber.d("Skipping rationale request in validatePermissions()!")
                Toast.makeText(this@HomeActivity,"Fail",Toast.LENGTH_SHORT).show()
            }
        })
        .check()*/


        //view binding ya databinding

        /*var cardLiveLocation=findViewById<MaterialCardView>(R.id.livelocation)
        var compass=findViewById<MaterialCardView>(R.id.compass)
        var speedoMeter = findViewById<MaterialCardView>(R.id.cardSpeedoMeter)
        var ussdCode =findViewById<MaterialCardView>(R.id.ussdCode)
        var nearPlaces= findViewById<MaterialCardView>(R.id.cardNearByPlaces)
        var trafficFinder = findViewById<MaterialCardView>(R.id.trafficFinder)*/

        binding.abc.cardRating.setOnClickListener {
            val uri: Uri = Uri.parse("market://details?id=$packageName")
            val goToMarket = Intent(Intent.ACTION_VIEW, uri)
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(
                Intent.FLAG_ACTIVITY_NO_HISTORY or
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK
            )
            try {
                startActivity(goToMarket)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }
        }

        binding.abc.cardFeedback.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val recipients = arrayOf("appzone17@gmail.com") //Add multiple recipients here

            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback") //Add Mail Subject

            intent.putExtra(Intent.EXTRA_TEXT, "") //Add mail body
            intent.type = "text/html"
            intent.setPackage("com.google.android.gm") //Added Gmail Package to forcefully open Gmail App

            startActivity(Intent.createChooser(intent, "Send mail"))
        }

        binding.abc.cardContacts.setOnClickListener {

            var intent = Intent(this, ContactListActivity::class.java)
            startActivity(intent)
        }

        binding.abc.cardSearch.setOnClickListener {
            var intent = Intent(this, SearchNumberActivity::class.java)
            startActivity(intent)
        }

        binding.abc.cardAreaCodes.setOnClickListener {
            var intent = Intent(this, AreaCodeActivity::class.java)
            startActivity(intent)
        }

        binding.abc.trafficFinder.setOnClickListener {
            var intent = Intent(this, TrafficFinderActivity::class.java)
            startActivity(intent)
        }

        //imgShare = findViewById(R.id.share)

        binding.abc.cardShare!!.setOnClickListener(View.OnClickListener {
            /*launchShareIntent().apply{
                body =""
                sub =""
            }*/
            /*
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val body = "Beta Angel's"
            val sub = "Sub"
            intent.putExtra(Intent.EXTRA_SUBJECT, sub)
            intent.putExtra(Intent.EXTRA_TEXT, body)
            startActivity(Intent.createChooser(intent, "Share using"))*/

            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                var shareMessage = "\nLet me recommend you this application\n\n"
                shareMessage =
                    """
                    ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                    
                    
                    """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        })

        binding.abc.cardNearByPlaces.setOnClickListener {
            val intent = Intent(this, NearPlacesActivity::class.java)
            startActivity(intent)
        }

        binding.abc.ussdCode.setOnClickListener {
            val intent = Intent(this, USSDCodeActivity::class.java)
            startActivity(intent)
        }

        binding.abc.cardSpeedoMeter.setOnClickListener {
            val intent = Intent(this, SpeedoMeterActivity::class.java)
            startActivity(intent)
        }

        binding.abc.livelocation.setOnClickListener {
            val intent = Intent(this, LiveLocationActivity::class.java)
            startActivity(intent)
        }

        binding.abc.compass.setOnClickListener {
            val intent = Intent(this, CompassActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        /*val binding = AlertdialogBinding.inflate(layoutInflater)
        val dialog = Dialog(this@HomeActivity)
        binding.exitBtn.setOnClickListener { v ->
            dialog.dismiss()
            finishAffinity()
        }
        binding.rateBtn.setOnClickListener { v ->
            dialog.dismiss()
            rateApp()
        }
        dialog.setContentView(binding.root)
        dialog.show()
        val window: Window = dialog.getWindow()!!
        window.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )*/
       /*
        val mDialog = MaterialDialog.Builder(this)
            .setTitle("Rate us")
            .setMessage("Are you sure you want to exit??")
            .setCancelable(false)
            .setPositiveButton(
                "Rate us", R.drawable.ic_baseline_star_rate_24
            ) { dialogInterface, which ->
                dialogInterface.dismiss()
                rateApp()
            }
            .setNegativeButton(
                "Exit", R.drawable.ic_baseline_exit_to_app_24
            ) { dialogInterface, which -> dialogInterface.dismiss()
                finishAffinity()}
            .build()

        // Show Dialog

        // Show Dialog
        mDialog.show()*/

        val mBottomSheetDialog = BottomSheetMaterialDialog.Builder(this)
            .setTitle("Rate us")
            .setMessage("Are you sure you want to exit??")
            .setCancelable(true)
            .setAnimation(R.raw.rate)
            .setPositiveButton(
                "Rate us", R.drawable.ic_baseline_star_rate_24
            ) { dialogInterface, which ->
                dialogInterface.dismiss()
                rateApp()
            }
            .setNegativeButton(
                "Exit", R.drawable.ic_baseline_exit_to_app_24
            ) { dialogInterface, which -> dialogInterface.dismiss()
                finishAffinity()}
            .build()
        // Show Dialog

        // Show Dialog
        mBottomSheetDialog.show()
    }

    private fun rateApp() {
        val uri = Uri.parse("market://details?id=" + applicationContext.packageName)
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
        goToMarket.addFlags(
            Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )
        try {
            startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + applicationContext.packageName)
                )
            )
        }
    }


    @Throws(ActivityNotFoundException::class)
    fun showMap(place: String) {
        try {
            val gmmIntentUri = Uri.parse(
                "geo:" + "?z=10&q="
                        + place
            )
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        } catch (exception: ActivityNotFoundException) {
        }
    }


}