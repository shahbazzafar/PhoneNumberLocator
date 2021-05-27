package com.example.phonenumbertracker.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.activities.SearchNumberActivity
import com.example.phonenumbertracker.models.CustomCodeDetailsItem
import java.util.*
import kotlin.coroutines.coroutineContext



class CustomCodeDetailsAdapter(customItems: ArrayList<CustomCodeDetailsItem>, var context: Context) : RecyclerView.Adapter<CustomCodeDetailsAdapter.CustomViewHolder>() {
    private val mCustomList: ArrayList<CustomCodeDetailsItem>

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var linearLayout: LinearLayout
        var txtPackageName: TextView
        var txtActivate: TextView
        //var txtDeactivate: TextView

        init {
            txtPackageName = itemView.findViewById(R.id.txtPackageName)
            txtActivate = itemView.findViewById(R.id.txtActivate)
            //txtDeactivate = itemView.findViewById(R.id.txtDeactivate)
            linearLayout = itemView.findViewById(R.id.linearCodeDetails)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(R.layout.code_details_list_item, null)
        return CustomViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem: CustomCodeDetailsItem = mCustomList[position]
        holder.txtPackageName.setText(currentItem.packageName)
        holder.txtActivate.setText(currentItem.subscribe)
        //holder.txtDeactivate.setText(currentItem.unsubscribe)
        holder.linearLayout.setOnClickListener { v ->
            
            var textView = v.findViewById<View>(R.id.txtPackageName) as TextView
            var text = textView.text.toString()
            Log.e("ABC",text)



        }
    }

    override fun getItemCount(): Int {
        return mCustomList.size
    }

    init {
        mCustomList = customItems
    }
}



