package com.example.mobilephone.mobile_list_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobilephone.data.repositories.MobileRepository

@Suppress("UNCHECKED_CAST")
class MobileListViewModelFactory(val mobileRepository: MobileRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MobileListViewModel(mobileRepository) as T
    }
}