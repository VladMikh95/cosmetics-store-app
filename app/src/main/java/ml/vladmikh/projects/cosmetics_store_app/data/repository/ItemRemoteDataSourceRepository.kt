package ml.vladmikh.projects.cosmetics_store_app.data.repository

import ml.vladmikh.projects.cosmetics_store_app.data.network.ApiService
import javax.inject.Inject

class ItemRemoteDataSourceRepository @Inject constructor (private val apiService: ApiService) {

    suspend fun getItemRemoteDataSource() = apiService.getItemesRemoteDataSource()
}