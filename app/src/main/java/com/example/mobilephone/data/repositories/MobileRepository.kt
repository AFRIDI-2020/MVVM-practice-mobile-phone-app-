package com.example.mobilephone.data.repositories

import com.example.mobilephone.data.database.MobilePhoneDatabase
import com.example.mobilephone.data.database.entities.Mobile

class MobileRepository(val mobilePhoneDatabase: MobilePhoneDatabase) {
    suspend fun upsert_repository(mobile: Mobile) = mobilePhoneDatabase.mobileDao().upsertMobile(mobile)
    suspend fun delete_repository(mobile: Mobile) = mobilePhoneDatabase.mobileDao().deleteMobile(mobile)
    fun getMobileListRepo() = mobilePhoneDatabase.mobileDao().getMobileList()
}