package com.example.mobilephone.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobilephone.data.database.dao.AndroidDao
import com.example.mobilephone.data.database.dao.MobileDao
import com.example.mobilephone.data.database.entities.Android
import com.example.mobilephone.data.database.entities.Mobile

@Database(entities = [Mobile::class, Android::class], version = 1)
abstract class MobilePhoneDatabase : RoomDatabase() {
    abstract fun mobileDao(): MobileDao
    abstract fun androidDao() : AndroidDao

    companion object {
        @Volatile
        private var instance: MobilePhoneDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }


        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                MobilePhoneDatabase::class.java,
                "mobile_phone_database.db"
            ).build()
    }
}