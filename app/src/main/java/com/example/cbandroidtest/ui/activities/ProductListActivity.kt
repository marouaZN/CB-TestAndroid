package com.example.cbandroidtest.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cbandroidtest.R
import com.example.cbandroidtest.data.RoomDatabase.DatabaseBuilder
import com.example.cbandroidtest.ui.adapters.ProductAdapter
import com.example.cbandroidtest.data.models.ProductModel
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListActivity : AppCompatActivity() {
    var products: List<ProductModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

       products = getData()
        rvProductList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)

        // Create adapter
        val adapter = ProductAdapter(products)

        // Attach the adapter to the recyclerview to populate items
        rvProductList.adapter = adapter
    }

    private fun getData(): List<ProductModel> {
       return DatabaseBuilder.getInstance(this).productDao().getAll()
    }

}