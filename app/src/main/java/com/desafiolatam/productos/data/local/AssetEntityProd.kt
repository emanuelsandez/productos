package com.desafiolatam.productos.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "asset_table_prod")
data class AssetEntityProd (
    @PrimaryKey
    val id: String,
    val title: String?,
    val price: String?,
    val description: String?,
    val images: String?,
    val creationAt: String?,
    val comment: String?,


) : Serializable