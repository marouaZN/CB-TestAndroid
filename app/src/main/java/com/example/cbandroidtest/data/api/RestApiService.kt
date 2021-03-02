package com.example.cbandroidtest.data.api

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.cbandroidtest.data.RoomDatabase.DatabaseBuilder
import com.example.cbandroidtest.data.models.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun getProduct(barcode: Long, cnx: Context, callBack: (pm: ProductModel) -> Unit) {
        var pDao = DatabaseBuilder.getInstance(cnx).productDao()
        var product:ProductModel = pDao.findByCode(barcode)
        if (product != null)
            callBack(product)
        else{
            val retrofit = ServiceBuilder.buildService(RestApiInterface::class.java)
            retrofit.getProduct(barcode).enqueue(
                object : Callback<ProductModel> {
                    override fun onFailure(call: Call<ProductModel>, t: Throwable) {
                        Log.d("mza", "error is === " + t.message)
                        error(t)
                    }

                    override fun onResponse(
                        call: Call<ProductModel>,
                        response: Response<ProductModel>
                    ) {
                        product = response.body()!!
                        if (product.statusVerbose == "product found")
                            pDao.insertAll(product)
                        else
                            Toast.makeText(cnx, "Product not found", Toast.LENGTH_SHORT).show()
                        callBack(product)
                    }
                }
            )
        }
    }
}