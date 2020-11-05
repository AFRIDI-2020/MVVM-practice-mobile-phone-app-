package com.example.mobilephone.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mobile_phone_list")
class Mobile (
    @ColumnInfo(name = "brand") var brand : String,
    @ColumnInfo(name = "model") var model : String,
    @ColumnInfo(name = "price") var price : Double
){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}