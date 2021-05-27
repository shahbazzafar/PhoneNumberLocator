package com.example.phonenumbertracker.activities

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.adapters.CustomNearByPlacesAdapter
import com.example.phonenumbertracker.models.CustomNearByPlacesItem
import java.util.*


class NearPlacesActivity : AppCompatActivity() {
    var btnHotels: TextView? = null
    var context: Context? = null
    private var mRecyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_near_places)
        val toolbar =
            findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))
        val newString: String?
        newString = if (savedInstanceState == null) {
            val extras = intent.extras
            extras?.getString("cTitle")
        } else {
            savedInstanceState.getSerializable("cTitle") as String?
        }

        var edtData = findViewById<EditText>(R.id.myEditText)
        var btnSearch = findViewById<TextView>(R.id.txtSearch)
        btnSearch.setOnClickListener {
            showMap(edtData.text.toString())
        }


        /*btnHotels=findViewById(R.id.btnHotels);

        btnHotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap("https://www.google.com/maps/search/Hotels/");
            }
        });*/supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })

        val arrayList =
            ArrayList<CustomNearByPlacesItem>()
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Airport"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "ATM"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Bakery"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Bank"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Beauty Saloon"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Bus Station"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Cafe"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Car Repair"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Car Wash"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Car Dealers"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Dance Bar"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Dry Cleaning"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Electronics"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Gym"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Groceries"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Hotels"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Hospitals"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Libraries"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Petrol"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Post"))
        arrayList.add(CustomNearByPlacesItem(R.drawable.ic_map_marker, "Parking"))
        mRecyclerView = findViewById(R.id.mRerecyclerUSSDViewNearByPlaces)
        mRecyclerView!!.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(applicationContext)
        adapter = CustomNearByPlacesAdapter(arrayList, this)
        mRecyclerView!!.setLayoutManager(mLayoutManager)
        mRecyclerView!!.setAdapter(adapter)
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