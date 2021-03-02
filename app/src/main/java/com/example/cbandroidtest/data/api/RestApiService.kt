package com.example.cbandroidtest.api

import android.util.Log
import com.example.cbandroidtest.data.models.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun getProduct(barcode: Long) {
        val retrofit = ServiceBuilder.buildService(RestApiInterface::class.java)
         retrofit.getProduct(barcode).enqueue(
             object : Callback<ProductModel> {
                override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                    Log.d("mza", "error is === " + t.message)
                    error(t)
                }
                override fun onResponse( call: Call<ProductModel>, response: Response<ProductModel>) {
                    val product = response.body()
                    Log.d("mza", "product is ==== " + product)

                }
            }
        )
    }
}