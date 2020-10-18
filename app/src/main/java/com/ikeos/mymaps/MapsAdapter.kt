package com.ikeos.mymaps

import android.content.Context
import android.service.autofill.TextValueSanitizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.ikeos.mymaps.models.UserMap

class MapsAdapter(val context: Context, val userMaps: List<UserMap>, val onClickListener: OnClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    //implement an onclicklistener interface for communicating with the adapter
    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //create and return a ViewHolder by creating view from the inflater
        val view = LayoutInflater.from(context).inflate(R.layout.item_user_map, parent, false)
        return ViewHolder(view);
    }

    override fun getItemCount() = userMaps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //bind the data to the layout id @ text1
        val userMap = userMaps[position]
        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(position)
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(R.id.tvMapTitle)
        val textViewMarkerCount = holder.itemView.findViewById<TextView>(R.id.tvMarkerCount)
        textViewMarkerCount.text = "${userMap.places.size}"
        textViewTitle.text = userMap.title
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
