package com.example.cbandroidtest.models

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Foo",
    foreignKeys = [
        ForeignKey(entity = ProductInfo::class,
            parentColumns = ["pid"],
            childColumns = ["infoid"],
            onDelete = CASCADE)])
data class ProductModel(
    @PrimaryKey val pid: Int,
    @ColumnInfo(name = "code") @SerializedName("code")var barCode: Long?)
  //  @SerializedName("product") val productInfo: ProductInfo?)
