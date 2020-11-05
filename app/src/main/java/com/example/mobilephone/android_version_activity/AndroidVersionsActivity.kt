package com.example.mobilephone.android_version_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilephone.R
import com.example.mobilephone.data.database.MobilePhoneDatabase
import com.example.mobilephone.data.repositories.AndroidRepository
import com.example.mobilephone.databinding.ActivityAndroidVersionsBinding
import kotlinx.android.synthetic.main.activity_android_versions.*

class AndroidVersionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding  : ActivityAndroidVersionsBinding = DataBindingUtil.setContentView(this,R.layout.activity_android_versions)
        val database = MobilePhoneDatabase(this)
        val androidRepository = AndroidRepository(database)
        val factory = AndroidVersionFactory(androidRepository)
        val androidVersionsViewModel = ViewModelProvider(this,factory).get(AndroidVersionsViewModel::class.java)
        binding.androidVersionsViewModel = androidVersionsViewModel

        val androidVersionsAdapter = AndroidVersionsAdapter(listOf(),androidVersionsViewModel)
        android_version_RV.layoutManager = LinearLayoutManager(this)
        android_version_RV.adapter = androidVersionsAdapter

        androidVersionsViewModel.getAllAndroidVersions().observe(this, Observer {
            androidVersionsAdapter.androidVersionList = it
            androidVersionsAdapter.notifyDataSetChanged()

        })

        val itemTouchHelperCallback = object  : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                androidVersionsAdapter.remove(viewHolder)
            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(android_version_RV)
    }
}