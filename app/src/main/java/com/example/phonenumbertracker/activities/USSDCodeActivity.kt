package com.example.phonenumbertracker.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.adapters.CustomUSSDCodeAdapter
import com.example.phonenumbertracker.models.CustomUSSDCodeItem
import java.util.*


class USSDCodeActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_s_s_d_code)
        val toolbar =
            findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
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
        val arrayList =
            ArrayList<CustomUSSDCodeItem>()
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Zong (Pak)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Jazz (Pak)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Ufone (Pak)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Telenor (Pak)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Warid (Pak)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Airtel (India)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "BSNL (India)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Aircel (India)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Idea (India)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Vodafone (India)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Tata Docomo (India)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Reliance (India)"))
        arrayList.add(CustomUSSDCodeItem(R.drawable.sim, "Telenor (India)"))
        mRecyclerView = findViewById(R.id.mRerecyclerUSSDView)
        mRecyclerView!!.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(applicationContext)
        adapter = CustomUSSDCodeAdapter(arrayList, this)
        mRecyclerView!!.setLayoutManager(mLayoutManager)
        mRecyclerView!!.setAdapter(adapter)
    }
}