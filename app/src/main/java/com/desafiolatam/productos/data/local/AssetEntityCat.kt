package com.desafiolatam.productos.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "asset_table_cat")
data class AssetEntityCat(
    @PrimaryKey
    val idCategory: String,
    val nameCategory: String?,
    val imageCategory: String?,
): Serializable
