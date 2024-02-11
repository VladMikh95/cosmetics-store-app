package ml.vladmikh.projects.cosmetics_store_app.data.network

import ml.vladmikh.projects.cosmetics_store_app.data.network.model.ItemRemoteDataSource
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v3/ff929d4d-505f-4331-916a-dcfac127aec4")
    suspend fun getItemesRemoteDataSource(): Response<ItemRemoteDataSource>

}