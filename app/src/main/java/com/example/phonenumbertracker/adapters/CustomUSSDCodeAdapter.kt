package com.example.phonenumbertracker.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.phonenumbertracker.models.CustomUSSDCodeItem
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.activities.USSDCodeDetailsActivity
import java.util.*


class CustomUSSDCodeAdapter(
    private val mCustomList: ArrayList<CustomUSSDCodeItem>,
    var context: Context
) :
    RecyclerView.Adapter<CustomUSSDCodeAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var linearLayout: LinearLayout
        var txtSim: TextView
        var imgCardSim: ImageView

        init {
            txtSim = itemView.findViewById(R.id.txtSim)
            imgCardSim = itemView.findViewById(R.id.imgCardSim)
            linearLayout = itemView.findViewById(R.id.linearCode)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.ussd_code_list_item, null)
        return CustomViewHolder(rootView)
    }

    override fun onBindViewHolder(
        holder: CustomViewHolder,
        position: Int
    ) {
        val currentItem = mCustomList[position]
        holder.txtSim.setText(currentItem.text)
        holder.imgCardSim.setImageResource(currentItem.img)
        holder.linearLayout.setOnClickListener {


            var text1 = holder.txtSim.text.toString()

            var intent= Intent(context,USSDCodeDetailsActivity::class.java)
            intent.putExtra("cTitle",text1)

            context.startActivity(intent);
        }
    }

    override fun getItemCount(): Int {
        return mCustomList.size
    }

}


