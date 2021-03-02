package com.example.cbandroidtest.ui.activities

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import com.example.cbandroidtest.R
import com.example.cbandroidtest.data.RoomDatabase.DatabaseBuilder
import kotlinx.android.synthetic.main.activity_product_details.*
import java.text.SimpleDateFormat
import java.util.*

class ProductDetailsActivity : AppCompatActivity() {

    var cal = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        EtExpiryDate.hint = "--/--/----"

        val intent = intent
        var code = intent.getLongExtra("CODE", 0)
        var pDao = DatabaseBuilder.getInstance(this).productDao()
        var product = pDao.findByCode(code)

        // recuperate code
        TvBarCode.text = "" + code

        // expiry date
        EtExpiryDate!!.text = "" + (product.productInfo?.expiryDate ?: "--/--/----")

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView(year, monthOfYear, dayOfMonth)
            }
        }

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        EtExpiryDate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@ProductDetailsActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })

        //save expiry date
        btnConfirm.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ProductListActivity::class.java)
            product.productInfo?.expiryDate = EtExpiryDate.text as String?
            pDao.updatExpirencyDate(product)
            startActivity(intent)
            finish()
        })

    }

    private fun updateDateInView(year: Int, month: Int, day: Int) {
        val myFormat = "dd/MM/yyyy" // the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        EtExpiryDate!!.text = sdf.format(cal.time)
    }
}