package com.example.cbandroidtest.data.models

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity
data class ProductModel(
    @PrimaryKey(autoGenerate = true) val pid: Int,
    @ColumnInfo(name = "code") @SerializedName("code")var barCode: Long?,
    @SerializedName("status_verbose")var statusVerbose: String,
    @Embedded @SerializedName("product") var productInfo: ProductInfo?)
