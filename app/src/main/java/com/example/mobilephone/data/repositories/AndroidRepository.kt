package com.example.mobilephone.data.repositories

import com.example.mobilephone.data.database.MobilePhoneDatabase
import com.example.mobilephone.data.database.entities.Android

class AndroidRepository(val mobilePhoneDatabase: MobilePhoneDatabase) {

    suspend fun upsert(android: Android) = mobilePhoneDatabase.androidDao().upsert(android)
    suspend fun delete(android: Android) = mobilePhoneDatabase.androidDao().delete(android)
    fun getAndroidVersions() = mobilePhoneDatabase.androidDao().getAndroidVersions()
}