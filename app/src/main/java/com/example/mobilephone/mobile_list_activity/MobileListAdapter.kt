package com.example.mobilephone.mobile_list_activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilephone.R
import com.example.mobilephone.data.database.entities.Mobile
import kotlinx.android.synthetic.main.mobile_item.view.*

class MobileListAdapter(
    var mobileList: List<Mobile>,
    val mobileListViewModel: MobileListViewModel
) : RecyclerView.Adapter<MobileListAdapter.MobileListViewHolder>() {

    inner class MobileListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mobile_item,parent,false)
        return MobileListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mobileList.size
    }

    override fun onBindViewHolder(holder: MobileListViewHolder, position: Int) {
        val mobile = mobileList[position]

        holder.itemView.brand_name_TV.text = mobile.brand
        holder.itemView.model_name_TV.text = mobile.model
        holder.itemView.amountTV.text = mobile.price.toString()
    }
}