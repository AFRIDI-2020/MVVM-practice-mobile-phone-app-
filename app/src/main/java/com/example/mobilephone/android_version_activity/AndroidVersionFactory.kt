package com.example.mobilephone.android_version_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobilephone.data.repositories.AndroidRepository

@Suppress("UNCHECKED_CAST")
class AndroidVersionFactory(val androidRepository: AndroidRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AndroidVersionsViewModel(androidRepository) as T
    }
}