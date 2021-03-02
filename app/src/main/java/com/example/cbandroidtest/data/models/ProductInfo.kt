package com.example.cbandroidtest.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ProductInfo (
    @PrimaryKey val infoid: Int,
    @ColumnInfo(name = "picture")  @SerializedName("image_url") var picture: String?,
    @ColumnInfo(name = "expiry_date")  @SerializedName("expiration_date") var expiryDate: String?,
    @ColumnInfo(name = "product_name")  @SerializedName("product_name")  var name: String?)