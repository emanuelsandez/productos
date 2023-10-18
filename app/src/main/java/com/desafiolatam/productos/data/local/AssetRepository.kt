package com.desafiolatam.productos.data.local

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class AssetRepository (private val assetDao: AssetDao) {
    val allAssets: LiveData<List<AssetEntityCat>> = assetDao.getCategoriesAssets()

    @WorkerThread
    fun insertAsset(asset: AssetEntityCat) {
        assetDao.insertAsset(asset)
    }


   /* @WorkerThread
    fun updateAssetCat(assetEntityProd: AssetEntityProd) {
        assetDao.addAssetProd(assetEntityProd)
    }
*/

    @WorkerThread
    fun deleteAssets() {
        assetDao.deleteAssets()
    }

    @WorkerThread
    fun addComment(assetEntityProd: AssetEntityProd) {
        assetDao.addComment(assetEntityProd)
    }

}