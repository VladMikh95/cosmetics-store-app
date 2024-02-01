package ml.vladmikh.projects.cosmetics_store_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ml.vladmikh.projects.cosmetics_store_app.data.local.dao.UserDao
import ml.vladmikh.projects.cosmetics_store_app.data.local.entities.UserLocalDataSource

@Database(entities = [UserLocalDataSource::class], version = 1, exportSchema = false)
abstract class CosmeticsStoreDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
}