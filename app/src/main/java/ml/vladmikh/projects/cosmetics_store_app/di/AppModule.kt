package ml.vladmikh.projects.cosmetics_store_app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ml.vladmikh.projects.cosmetics_store_app.data.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository = UserRepository()


}