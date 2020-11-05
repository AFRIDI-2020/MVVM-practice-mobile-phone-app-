package com.example.mobilephone.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mobilephone.data.database.entities.Mobile

@Dao
interface MobileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMobile(mobile: Mobile)

    @Delete
    suspend fun deleteMobile(mobile: Mobile)

    @Query("SELECT * FROM mobile_phone_list ORDER BY id DESC")
    fun getMobileList() : LiveData<List<Mobile>>
}