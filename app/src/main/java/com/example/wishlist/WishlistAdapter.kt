package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val items: List<WishlistItem>) : RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder>() {

    inner class WishlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNameTv: TextView = itemView.findViewById(R.id.itemNameTv)
        val itemPriceTv: TextView = itemView.findViewById(R.id.itemPriceTv)
        val itemUrlTv: TextView = itemView.findViewById(R.id.itemUrlTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistAdapter.WishlistViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return WishlistViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WishlistAdapter.WishlistViewHolder, position: Int) {
        val item = items[position]
        holder.itemNameTv.text = item.item
        holder.itemPriceTv.text = item.price
        holder.itemUrlTv.text = item.url
    }

    override fun getItemCount(): Int {
        return items.size
    }

}