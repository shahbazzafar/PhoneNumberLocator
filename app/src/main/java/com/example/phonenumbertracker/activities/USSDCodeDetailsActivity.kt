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
import com.example.phonenumbertracker.adapters.CustomCodeDetailsAdapter
import com.example.phonenumbertracker.models.CustomCodeDetailsItem


class USSDCodeDetailsActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_s_s_d_code_details)

        val toolbar =
            findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        var textData = intent.getStringExtra("cTitle")

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))

        toolbar.setNavigationOnClickListener(View.OnClickListener {
            var intent = Intent(this, USSDCodeActivity::class.java)
            startActivity(intent)
        })

        var arrayListZong: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListJazz: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListUfone: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListTelenor: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListWarid: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListAirtel: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListVodafone: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListTataDocomo: ArrayList<CustomCodeDetailsItem> =
            ArrayList<CustomCodeDetailsItem>()
        var arrayListReliance: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListTelenorIndia: ArrayList<CustomCodeDetailsItem> =
            ArrayList<CustomCodeDetailsItem>()
        var arrayListBSNL: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListIdea: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()
        var arrayListAircel: ArrayList<CustomCodeDetailsItem> = ArrayList<CustomCodeDetailsItem>()

        var zong = resources.getStringArray(R.array.zong_package)
        var jazz = resources.getStringArray(R.array.jazz_package)
        var ufone = resources.getStringArray(R.array.ufone_package)
        var telenor = resources.getStringArray(R.array.telenor_package)
        var warid = resources.getStringArray(R.array.warid_package)
        var airtel = resources.getStringArray(R.array.airtel_package)
        var vodafone = resources.getStringArray(R.array.vodafone_package)
        var tataDocomo = resources.getStringArray(R.array.tata_docomo_package)
        var reliance = resources.getStringArray(R.array.reliance_package)
        var telenorIndia = resources.getStringArray(R.array.telenor_india_package)
        var bsnl = resources.getStringArray(R.array.bsnl_package)
        var idea = resources.getStringArray(R.array.idea_package)
        var aircel = resources.getStringArray(R.array.aircel_package)
        var i = 0

        if (textData.equals("Zong (Pak)")) {
            for (value in zong) {
                var packageName = resources.getStringArray(R.array.zong_package)[i]
                var subscribe = resources.getStringArray(R.array.zong_subscribe)[i]
                i++
                arrayListZong.add(CustomCodeDetailsItem(packageName, subscribe))
            }
        } else if (textData.equals("Jazz (Pak)")) {
            for (value in jazz) {
                var packageName = resources.getStringArray(R.array.jazz_package)[i]
                var subscribe = resources.getStringArray(R.array.jazz_subscribe)[i]
                i++
                arrayListJazz.add(CustomCodeDetailsItem(packageName, subscribe))
            }
        } else if (textData.equals("Ufone (Pak)")) {
            for (value in ufone) {
                var packageNAM = resources.getStringArray(R.array.ufone_package)[i]
                var subscribe = resources.getStringArray(R.array.ufone_subscribe)[i]
                i++
                arrayListUfone.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }
        } else if (textData.equals("Telenor (Pak)")) {
            for (value in telenor) {
                var packageNAM = resources.getStringArray(R.array.telenor_package)[i]
                var subscribe = resources.getStringArray(R.array.telenor_subscribe)[i]
                i++
                arrayListTelenor.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        } else if (textData.equals("Warid (Pak)")) {
            for (value in warid) {
                var packageNAM = resources.getStringArray(R.array.warid_package)[i]
                var subscribe = resources.getStringArray(R.array.warid_subscribe)[i]
                i++
                arrayListWarid.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        } else if (textData.equals("Airtel (India)")) {
            for (value in airtel) {
                var packageNAM = resources.getStringArray(R.array.airtel_package)[i]
                var subscribe = resources.getStringArray(R.array.airtel_subscribe)[i]
                i++
                arrayListAirtel.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        } else if (textData.equals("Vodafone (India)")) {
            for (value in vodafone) {
                var packageNAM = resources.getStringArray(R.array.vodafone_package)[i]
                var subscribe = resources.getStringArray(R.array.vodafone_subscribe)[i]
                i++
                arrayListVodafone.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        } else if (textData.equals("Tata Docomo (India)")) {
            for (value in tataDocomo) {
                var packageNAM = resources.getStringArray(R.array.tata_docomo_package)[i]
                var subscribe = resources.getStringArray(R.array.tata_docomo_subscribe)[i]
                i++
                arrayListTataDocomo.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        } else if (textData.equals("Reliance (India)")) {
            for (value in reliance) {
                var packageNAM = resources.getStringArray(R.array.reliance_package)[i]
                var subscribe = resources.getStringArray(R.array.reliance_subscribe)[i]
                i++
                arrayListReliance.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        } else if (textData.equals("Telenor (India)")) {
            for (value in telenorIndia) {
                var packageNAM = resources.getStringArray(R.array.telenor_india_package)[i]
                var subscribe = resources.getStringArray(R.array.telenor_india_subscribe)[i]
                i++
                arrayListTelenorIndia.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        } else if (textData.equals("BSNL (India)")) {
            for (value in bsnl) {
                var packageNAM = resources.getStringArray(R.array.bsnl_package)[i]
                var subscribe = resources.getStringArray(R.array.bsnl_subscribe)[i]
                i++
                arrayListBSNL.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        } else if (textData.equals("Idea (India)")) {
            for (value in idea) {
                var packageNAM = resources.getStringArray(R.array.idea_package)[i]
                var subscribe = resources.getStringArray(R.array.idea_subscribe)[i]
                i++
                arrayListIdea.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        } else if (textData.equals("Aircel (India)")) {
            for (value in aircel) {
                var packageNAM = resources.getStringArray(R.array.aircel_package)[i]
                var subscribe = resources.getStringArray(R.array.aircel_subscribe)[i]
                i++
                arrayListAircel.add(CustomCodeDetailsItem(packageNAM, subscribe))

            }

        }




        mRecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView!!.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(applicationContext)

        if (textData.equals("Zong (Pak)")) {
            adapter = CustomCodeDetailsAdapter(arrayListZong, this)
        } else if (textData.equals("Jazz (Pak)")) {
            adapter = CustomCodeDetailsAdapter(arrayListJazz, this)
        } else if (textData.equals("Ufone (Pak)")) {
            adapter = CustomCodeDetailsAdapter(arrayListUfone, this)
        } else if (textData.equals("Telenor (Pak)")) {
            adapter = CustomCodeDetailsAdapter(arrayListTelenor, this)
        } else if (textData.equals("Warid (Pak)")) {
            adapter = CustomCodeDetailsAdapter(arrayListWarid, this)
        } else if (textData.equals("Airtel (India)")) {
            adapter = CustomCodeDetailsAdapter(arrayListAirtel, this)
        } else if (textData.equals("Vodafone (India)")) {
            adapter = CustomCodeDetailsAdapter(arrayListVodafone, this)
        } else if (textData.equals("Tata Docomo (India)")) {
            adapter = CustomCodeDetailsAdapter(arrayListTataDocomo, this)
        } else if (textData.equals("Reliance (India)")) {
            adapter = CustomCodeDetailsAdapter(arrayListReliance, this)
        } else if (textData.equals("Telenor (India)")) {
            adapter = CustomCodeDetailsAdapter(arrayListTelenorIndia, this)
        } else if (textData.equals("BSNL (India)")) {
            adapter = CustomCodeDetailsAdapter(arrayListBSNL, this)
        } else if (textData.equals("Idea (India)")) {
            adapter = CustomCodeDetailsAdapter(arrayListIdea, this)
        } else if (textData.equals("Aircel (India)")) {
            adapter = CustomCodeDetailsAdapter(arrayListAircel, this)
        }

        mRecyclerView!!.setLayoutManager(mLayoutManager)
        mRecyclerView!!.setAdapter(adapter)

    }
}