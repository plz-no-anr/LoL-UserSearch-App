package com.plznoanr.data.db

import androidx.room.*
import com.plznoanr.data.model.local.SearchEntity

@Dao
interface AppDao {
    @Query("SELECT * FROM SearchEntity")
    suspend fun getSearch(): List<SearchEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearch(searchEntity: SearchEntity)

    @Query("DELETE FROM SearchEntity WHERE id = :uid")
    suspend fun deleteSearch(uid: Int)

    @Query("DELETE FROM SearchEntity")
    suspend fun deleteSearchAll()

}