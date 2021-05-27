package com.example.phonenumbertracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.models.CustomAreaCodesItem
import java.util.*


class CustomAreaCodesAdapter(private val mCustomList: ArrayList<CustomAreaCodesItem>) :
    RecyclerView.Adapter<CustomAreaCodesAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var linearLayout: RelativeLayout
        var countryName: TextView
        var countryCode: TextView

        init {
            countryName = itemView.findViewById(R.id.txtCountryName)
            countryCode = itemView.findViewById(R.id.txtCountryCode)
            linearLayout = itemView.findViewById(R.id.linearCode)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.area_code_list_item, null)
        return CustomViewHolder(rootView)
    }

    override fun onBindViewHolder(
        holder: CustomViewHolder,
        position: Int
    ) {
        val currentItem = mCustomList[position]
        holder.countryName.setText(currentItem.conutryname)
        holder.countryCode.setText(currentItem.countrycode.toString())
        holder.linearLayout.setOnClickListener { /*Intent intent=new Intent(v.getContext(),CustomizeFoodActivity.class);
                            intent.putExtra("cTitle",currentItem.getTitle());
                            intent.putExtra("cQuantity",currentItem.getQuantity());
                            intent.putExtra("cPrice",currentItem.getPrice());
                            v.getContext().startActivity(intent);*/
        }
    }

    override fun getItemCount(): Int {
        return mCustomList.size
    }

}


