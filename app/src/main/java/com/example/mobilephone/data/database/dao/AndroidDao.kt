package com.example.mobilephone.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mobilephone.data.database.entities.Android

@Dao
interface AndroidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(android: Android)

    @Delete
    suspend fun delete(android: Android)

    @Query("SELECT * FROM android ORDER BY id ASC")
    fun getAndroidVersions() : LiveData<List<Android>>
}