package com.desafiolatam.productos.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface AssetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAsset(assetEntityCat: AssetEntityCat)

    @Update
    fun updateAssetCat(assetEntityCat: AssetEntityCat)

    @Query("SELECT * FROM asset_table_cat ORDER BY cast(idCategory as unsigned) asc")
    fun getCategoriesAssets(): LiveData<List<AssetEntityCat>>

    @Query("SELECT * FROM asset_table_prod WHERE id = :id")
    fun getProdAsset(id: String): LiveData<AssetEntityProd>

    @Query("DELETE FROM asset_table_prod")
    fun deleteAssets()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addComment(assetEntityProd: AssetEntityProd)


}