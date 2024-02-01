package ml.vladmikh.projects.cosmetics_store_app.data.repository

import ml.vladmikh.projects.cosmetics_store_app.data.local.dao.UserDao
import ml.vladmikh.projects.cosmetics_store_app.data.local.entities.UserLocalDataSource
import javax.inject.Inject

class UserLocalDataSourceRepository  @Inject constructor(private val userDao: UserDao) {

    suspend fun insert(userLocalDataSource: UserLocalDataSource) = userDao.insert(userLocalDataSource)

    suspend fun update(userLocalDataSource: UserLocalDataSource) = userDao.update(userLocalDataSource)

    fun getAllUsers() = userDao.getAllUsers()

}