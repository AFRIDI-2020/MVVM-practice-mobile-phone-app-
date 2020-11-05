package com.example.mobilephone.android_version_activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilephone.R
import com.example.mobilephone.data.database.entities.Android
import kotlinx.android.synthetic.main.android_version_list_item_demo.view.*

class AndroidVersionsAdapter(
    var androidVersionList: List<Android>,
    val androidVersionsViewModel: AndroidVersionsViewModel
) : RecyclerView.Adapter<AndroidVersionsAdapter.ViewHolder>() {

    var removedPosition:Int = 0
    var removedItem : Android? = null

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.android_version_list_item_demo,parent,false)
        return ViewHolder(view)
    }

    fun remove(viewHolder : RecyclerView.ViewHolder){
        removedPosition = viewHolder.adapterPosition
        removedItem = androidVersionList[removedPosition]
        androidVersionsViewModel.delete(removedItem!!)
        notifyItemRemoved(removedPosition)
    }

    override fun getItemCount(): Int {
        return androidVersionList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val android = androidVersionList[position]

        holder.itemView.android_version_TV.text = android.version
        holder.itemView.android_version_name_TV.text = android.versionName
        holder.itemView.api_level_TV.text = android.apiLevel.toString()
    }


}