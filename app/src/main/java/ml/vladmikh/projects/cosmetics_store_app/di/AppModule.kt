package ml.vladmikh.projects.cosmetics_store_app.di

import dagger.Module
import android.content.Context
import dagger.Provides
import dagger.hilt.InstallIn
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ml.vladmikh.projects.cosmetics_store_app.data.local.CosmeticsStoreDatabase
import ml.vladmikh.projects.cosmetics_store_app.data.local.dao.UserDao
import ml.vladmikh.projects.cosmetics_store_app.data.local.entities.UserLocalDataSource
import ml.vladmikh.projects.cosmetics_store_app.data.network.ApiService
import ml.vladmikh.projects.cosmetics_store_app.data.repository.ItemRemoteDataSourceRepository
import ml.vladmikh.projects.cosmetics_store_app.data.repository.UserLocalDataSourceRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseUrl(): String = "https://run.mocky.io/"


    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun providesUserDao(database: CosmeticsStoreDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CosmeticsStoreDatabase {
        return Room.databaseBuilder(
            context,
            CosmeticsStoreDatabase::class.java,
            "cocktail_bar_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun providesUserLocalDataSourceRepository(userDao: UserDao): UserLocalDataSourceRepository =
        UserLocalDataSourceRepository(userDao)

    @Provides
    @Singleton
    fun providesItemRemoteDataSourceRepository(mainService: ApiService): ItemRemoteDataSourceRepository =
        ItemRemoteDataSourceRepository(mainService)
}