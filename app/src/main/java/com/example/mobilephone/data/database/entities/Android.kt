package com.example.mobilephone.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "android")
class Android (
    @ColumnInfo(name = "version") var version : String,
    @ColumnInfo(name = "version_name") var versionName : String,
    @ColumnInfo(name = "api_level") var apiLevel : Int
){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}