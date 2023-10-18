package com.desafiolatam.productos.data.remote

import com.desafiolatam.productos.data.local.AssetEntityCat


data class Data (val data: ArrayList<AssetEntityCat>,
                 val timestamp: Long
                 )