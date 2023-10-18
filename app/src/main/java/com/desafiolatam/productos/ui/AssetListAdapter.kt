package com.desafiolatam.productos.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.desafiolatam.productos.R
import com.desafiolatam.productos.data.local.AssetEntityCat

import com.desafiolatam.productos.databinding.AssetListCatBinding
import com.squareup.picasso.Picasso

class AssetListAdapter(var itemClick: OnItemClickListener) : ListAdapter<AssetEntityCat, AssetListAdapter.AssetEntityViewHolder>(AssetsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetEntityViewHolder {
        return AssetEntityViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AssetEntityViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
        holder.itemView.setOnClickListener {
            itemClick.onItemClick(current)
        }
    }

    class AssetEntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = AssetListCatBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(assetEntityCat: AssetEntityCat) {

            binding.assetNamecategory.text = assetEntityCat.nameCategory

            Picasso.get()
                .load("https://api.escuelajs.co/api/v1/products${assetEntityCat.imageCategory?.lowercase()}@2x.png")
                .into(binding.assetImagecategory)
            binding.assetNamecategory.text = assetEntityCat.nameCategory



        }

        companion object {
            fun create(parent: ViewGroup): AssetEntityViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.asset_list_cat, parent, false)
                return AssetEntityViewHolder(view)
            }
        }
    }

    class AssetsComparator : DiffUtil.ItemCallback<AssetEntityCat>() {
        override fun areItemsTheSame(oldItem: AssetEntityCat, newItem: AssetEntityCat): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: AssetEntityCat, newItem: AssetEntityCat): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }
    }
}