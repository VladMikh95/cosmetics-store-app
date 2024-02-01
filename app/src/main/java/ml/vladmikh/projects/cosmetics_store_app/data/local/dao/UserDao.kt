package ml.vladmikh.projects.cosmetics_store_app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ml.vladmikh.projects.cosmetics_store_app.data.local.entities.UserLocalDataSource

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userLocalDataSourse: UserLocalDataSource)

    @Update
    suspend fun update(userLocalDataSourse: UserLocalDataSource)

    @Query("SELECT * from user_table")
    fun getAllUsers(): Flow<List<UserLocalDataSource>>
}