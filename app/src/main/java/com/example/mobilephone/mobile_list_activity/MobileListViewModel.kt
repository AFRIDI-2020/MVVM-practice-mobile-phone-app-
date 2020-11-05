package com.example.mobilephone.mobile_list_activity

import androidx.lifecycle.ViewModel
import com.example.mobilephone.data.database.entities.Mobile
import com.example.mobilephone.data.repositories.MobileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MobileListViewModel(val mobileRepository: MobileRepository) : ViewModel() {

    fun upsert(mobile: Mobile) = CoroutineScope(Dispatchers.Main).launch {
        mobileRepository.upsert_repository(mobile)
    }

    fun delete(mobile: Mobile) = CoroutineScope(Dispatchers.Main).launch {
        mobileRepository.delete_repository(mobile)
    }

    fun getMobileList() = mobileRepository.getMobileListRepo()
}