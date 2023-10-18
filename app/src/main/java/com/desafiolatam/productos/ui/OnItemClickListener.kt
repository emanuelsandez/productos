package com.desafiolatam.productos.ui

import com.desafiolatam.productos.data.local.AssetEntityCat

interface OnItemClickListener {
    fun onItemClick(asset: AssetEntityCat)
}