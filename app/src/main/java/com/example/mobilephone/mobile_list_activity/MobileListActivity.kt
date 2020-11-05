package com.example.mobilephone.mobile_list_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilephone.R
import com.example.mobilephone.android_version_activity.AndroidVersionsActivity
import com.example.mobilephone.data.database.MobilePhoneDatabase
import com.example.mobilephone.data.database.entities.Mobile
import com.example.mobilephone.data.repositories.MobileRepository
import kotlinx.android.synthetic.main.activity_mobile_list.*
import kotlinx.android.synthetic.main.input_mobile_item.view.*

class MobileListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_list)

        val mobilePhoneDatabase = MobilePhoneDatabase(this)
        val mobileRepository = MobileRepository(mobilePhoneDatabase)
        val mobileListViewModelFactory = MobileListViewModelFactory(mobileRepository)
        val mobileListViewModel = ViewModelProvider(this, mobileListViewModelFactory).get(MobileListViewModel::class.java)

        val mobileListAdapter = MobileListAdapter(listOf(),mobileListViewModel)
        mobileListRV.layoutManager = LinearLayoutManager(this)
        mobileListRV.adapter = mobileListAdapter

        mobileListViewModel.getMobileList().observe(this, Observer {
            mobileListAdapter.mobileList = it
            mobileListAdapter.notifyDataSetChanged()
        })

        add_button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val view = LayoutInflater.from(this@MobileListActivity).inflate(R.layout.input_mobile_item,null)
            builder.setView(view)
            val dialog  = builder.create()


            view.ok_TV.setOnClickListener {
                val brandName = view.brand_name_ET.text.toString()
                val modelName = view.model_name_ET.text.toString()
                val price = view.price_ET.text.toString()

                if (brandName.isEmpty() || modelName.isEmpty() || price.isEmpty()) {
                    Toast.makeText(
                        this@MobileListActivity,
                        "Fill up all the fields.",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }else{
                    val mobile = Mobile(brandName, modelName, price.toDouble())
                    mobileListViewModel.upsert(mobile)
                    dialog.dismiss()
                }


            }

            view.cancel_TV.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()

        }
    }

    fun intentToAndroidVersionActivity(view: View) {
        startActivity(Intent(this,AndroidVersionsActivity::class.java))
    }


}