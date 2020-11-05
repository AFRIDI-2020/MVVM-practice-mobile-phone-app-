package com.example.mobilephone.android_version_activity

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mobilephone.data.database.entities.Android
import com.example.mobilephone.data.repositories.AndroidRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AndroidVersionsViewModel(val androidRepository: AndroidRepository) : ViewModel() {

    var androidVersion : String? = null
    var versionName : String? = null
    var apiLevel : String? = null

    fun upsert(android: Android) = CoroutineScope(Dispatchers.Main).launch {
        androidRepository.upsert(android)
    }

    fun delete(android: Android) = CoroutineScope(Dispatchers.Main).launch {
        androidRepository.delete(android)
    }

    fun getAllAndroidVersions() = androidRepository.getAndroidVersions()

    fun addAndroidVersionButtonClick(view : View){
        if(androidVersion.isNullOrEmpty() || versionName.isNullOrEmpty() || apiLevel.isNullOrEmpty()){
            return
        }
        val android = Android(androidVersion!!,versionName!!,apiLevel!!.toInt())
        upsert(android)
    }
}