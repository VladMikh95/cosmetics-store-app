package ml.vladmikh.projects.cosmetics_store_app.data.network

import ml.vladmikh.projects.cosmetics_store_app.data.network.model.ItemRemoteDataSource
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v3/97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getItemesRemoteDataSource(): Response<ItemRemoteDataSource>

}