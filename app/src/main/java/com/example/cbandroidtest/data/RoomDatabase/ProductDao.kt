package com.example.cbandroidtest.data.RoomDatabase

import androidx.room.*
import com.example.cbandroidtest.data.models.ProductModel

@Dao
interface ProductDao {
    @Query("SELECT * FROM productmodel")
    fun getAll(): List<ProductModel>

    @Insert
    fun insertAll(vararg products: ProductModel)

    @Query("SELECT * FROM productmodel where code = :code limit 1")
    fun findByCode(code: Long): ProductModel

    @Delete
    fun delete(product: ProductModel)

    @Update
    fun updatExpirencyDate(vararg products: ProductModel)
}