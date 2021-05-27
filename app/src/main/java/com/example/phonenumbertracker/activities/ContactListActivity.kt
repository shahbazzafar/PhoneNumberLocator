package com.example.phonenumbertracker.activities

import android.Manifest
import android.annotation.TargetApi
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.phonenumbertracker.R
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber


class ContactListActivity : AppCompatActivity() {

    var phoneNumberStr: String = ""


    val cols = listOf<String>(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    ).toTypedArray()


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                Array(1) { Manifest.permission.READ_CONTACTS },
                111
            )
        } else {
            read()
        }

        var toolbar = findViewById<Toolbar>(R.id.toolBarDesign)
        setSupportActionBar(toolbar)

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbar))
        var searchView = findViewById<SearchView>(R.id.searchView)


    }

    override fun onBackPressed() {
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            read()
        }
    }

    private fun read() {
        var cursor: Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        startManagingCursor(cursor)
        var listView1 = findViewById<ListView>(R.id.listview1)
        var searchView = findViewById<SearchView>(R.id.searchView)
        var from = listOf<String>(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        ).toTypedArray()
        var to = intArrayOf(android.R.id.text1, android.R.id.text2)
        var rs: Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )
        var adapter =
            SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, rs, from, to, 0)
        listView1.adapter = adapter

        searchView.setOnClickListener {
            searchView.setIconified(false)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                rs = contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    cols,
                    "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
                    Array(1) { "%$newText%" },
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                )
                adapter.changeCursor(rs)
                return false
            }
        })

        listView1.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val PhoneNumber: Int =
                rs!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            phoneNumberStr = rs!!.getString(PhoneNumber)
            val contactNumberName: String =
                rs!!.getString(rs!!.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
            Log.e("NameX", contactNumberName)
            var intent = Intent(this, ContactDetailsActivity::class.java)
            intent.putExtra("phone", phoneNumberStr)
            startActivity(intent)

            val utils = PhoneNumberUtil.getInstance()
            try {
                for (region in utils.supportedRegions) {
                    // Check whether it's a valid number.
                    var isValid = utils.isPossibleNumber(phoneNumberStr, region)
                    if (isValid) {
                        val number: PhoneNumber = utils.parse(phoneNumberStr, region)
                        // Check whether it's a valid number for the given region.
                        isValid = utils.isValidNumberForRegion(number, region)
                        if (isValid) {

                            Log.d("Region:", region) // IN
                            Log.d("Phone Code", number.countryCode.toString()) // 91
                            Log.d("Phone No.", number.nationalNumber.toString()) // 99xxxxxxxxxx

                            var intent = Intent(this, ContactDetailsActivity::class.java)
                            intent.putExtra("abcd", region)
                            intent.putExtra("phoneNumber", contactNumberName)
                            intent.putExtra("uzzo", phoneNumberStr)
                            Log.e("xyz", region)
                            startActivity(intent)
                        }
                    }
                }
            } catch (e: NumberParseException) {
                e.printStackTrace()
            }


        })


        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE)


    }


}