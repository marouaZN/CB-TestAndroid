package com.example.cbandroidtest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cbandroidtest.R
import com.example.cbandroidtest.models.ProductModel
import com.squareup.picasso.Picasso

class ProductAdapter(val productList: List<ProductModel>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    // Inflates the song layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_product_item, parent, false)
        return ViewHolder(view)
    }

    // Total number of songs
    override fun getItemCount(): Int {
        return productList.size
    }

    // Binds the data in each song
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productList.get(position)
       /* holder.tvName?.text = item.productInfo?.name
        holder.tvExpiryDate?.text = item.productInfo?.expiryDate
        if (item.productInfo?.picture != null)
            Picasso.get().load(item.productInfo.picture).into(holder.ivPicture); */
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView? = null
        var tvExpiryDate: TextView? = null
        var ivPicture: ImageView? = null

        init {
            tvName = itemView?.findViewById(R.id.tvProductName)
            tvExpiryDate = itemView?.findViewById(R.id.tvExpiryDate)
            ivPicture = itemView?.findViewById(R.id.ivPicture)
        }

    }
}