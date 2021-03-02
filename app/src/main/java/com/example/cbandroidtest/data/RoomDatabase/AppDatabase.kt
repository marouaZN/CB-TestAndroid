package com.example.cbandroidtest.data.RoomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cbandroidtest.data.models.ProductModel

@Database(entities = arrayOf(ProductModel::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}