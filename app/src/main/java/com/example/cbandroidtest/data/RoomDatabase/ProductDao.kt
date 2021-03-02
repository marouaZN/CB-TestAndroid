package com.example.cbandroidtest.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cbandroidtest.data.models.ProductModel

@Dao
interface ProductDao {
    @Query("SELECT * FROM productmodel")
    fun getAll(): List<ProductModel>

    @Insert
    fun insertAll(vararg products: ProductModel)

    @Delete
    fun delete(product: ProductModel)
}