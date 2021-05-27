package com.example.phonenumbertracker.adapters

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phonenumbertracker.R
import com.example.phonenumbertracker.adapters.CustomNearByPlacesAdapter.CustomViewHolder
import com.example.phonenumbertracker.models.CustomNearByPlacesItem
import java.util.*


class CustomNearByPlacesAdapter(
    private val mCustomList: ArrayList<CustomNearByPlacesItem>,
    var context: Context
) :
    RecyclerView.Adapter<CustomViewHolder>() {

    class CustomViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var linearLayout: LinearLayout
        var txtSim: TextView
        var imgCardSim: ImageView

        init {
            txtSim = itemView.findViewById(R.id.txtNearByPlaces)
            imgCardSim = itemView.findViewById(R.id.imgCardSim)
            linearLayout = itemView.findViewById(R.id.linearCode)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.near_by_places_list_item, null)
        return CustomViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = mCustomList[position]
        holder.txtSim.setText(currentItem.text)
        holder.imgCardSim.setImageResource(currentItem.img)
        holder.linearLayout.setOnClickListener { v -> /*Intent intent=new Intent(v.getContext(),NearPlacesActivity.class);
                            intent.putExtra("cTitle",currentItem.getText());

                            v.getContext().startActivity(intent);*/
            val textView =
                v.findViewById<View>(R.id.txtNearByPlaces) as TextView
            val text = textView.text.toString()
            showMap(text)
        }
    }

    override fun getItemCount(): Int {
        return mCustomList.size
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
            context.startActivity(mapIntent)
        } catch (exception: ActivityNotFoundException) {
        }
    }

}
