package com.example.cbandroidtest.data.api

import com.example.cbandroidtest.data.models.ProductModel
import retrofit2.Call
import retrofit2.http.*

interface RestApiInterface {
    @Headers("Content-Type: application/json")

    @GET("/api/v0/product/{code}")
    fun getProduct(@Path("code") code: Long): Call<ProductModel>
}