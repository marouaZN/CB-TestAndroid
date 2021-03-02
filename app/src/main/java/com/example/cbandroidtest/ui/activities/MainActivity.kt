package com.example.cbandroidtest.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cbandroidtest.R
import com.example.cbandroidtest.data.api.RestApiService
import com.example.cbandroidtest.data.models.ProductModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var apiService: RestApiService
    lateinit var code: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RestApiService()

        EtBarCode.hint = "Generate code";

        // scan code
        btnGenerateCode.setOnClickListener {
            code = EtBarCode.text.toString()
            if (code.isEmpty()) {
                return@setOnClickListener
            }

            apiService.getProduct(code.toLong(), this){
                val i = Intent(this, ProductDetailsActivity::class.java)
                i.putExtra("CODE", it.barCode)
                startActivity(i)
            }
        }

        //view all products
        btnViewAll.setOnClickListener(View.OnClickListener {
            intent = Intent(this, ProductListActivity::class.java)
            startActivity(intent)
        })

    }

    fun goToProductDetail(pm: ProductModel){
        val i = Intent(this, ProductDetailsActivity::class.java)
        i.putExtra("CODE", pm.barCode)
        startActivity(i)
    }
}