package com.example.cbandroidtest.ui.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cbandroidtest.R
import com.example.cbandroidtest.data.models.ProductModel
import com.example.cbandroidtest.ui.activities.ProductDetailsActivity
import com.squareup.picasso.Picasso

class ProductAdapter(val productList: List<ProductModel>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    // Inflates the song layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_product_item, parent, false)
        return ViewHolder(view)
    }

    // Total number of products
    override fun getItemCount(): Int {
        return productList.size
    }

    // Binds the data in each song
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productList.get(position)
        val context = holder.view.context

        holder.tvName?.text = item.productInfo?.name
        holder.tvExpiryDate?.text = item.productInfo?.expiryDate
        holder.tvCode?.text = "" + item.barCode
        if (item.productInfo?.picture != null)
            Picasso.get().load(item.productInfo!!.picture).into(holder.ivPicture);

        // click on item to update expiry date
        holder.view.setOnClickListener{
            val i = Intent(context, ProductDetailsActivity::class.java)
            i.putExtra("CODE", item.barCode)
            i.putExtra("DATE",item.productInfo?.expiryDate)
            context.startActivity(i)
            (context as Activity).finish()
        }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var tvCode: TextView? = null
        var tvName: TextView? = null
        var tvExpiryDate: TextView? = null
        var ivPicture: ImageView? = null

        init {
            tvCode = itemView?.findViewById(R.id.tvProductCode)
            tvName = itemView?.findViewById(R.id.tvProductName)
            tvExpiryDate = itemView?.findViewById(R.id.tvExpiryDate)
            ivPicture = itemView?.findViewById(R.id.ivPicture)
        }
    }
}