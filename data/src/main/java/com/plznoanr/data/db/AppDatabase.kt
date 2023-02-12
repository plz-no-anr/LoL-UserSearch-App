package com.plznoanr.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.plznoanr.data.model.local.ProfileEntity
import com.plznoanr.data.model.local.SearchEntity
import com.plznoanr.data.model.local.SummonerEntity
import com.plznoanr.data.utils.RoomTypeConverter

@Database(
    entities = [
        SummonerEntity::class,
        SearchEntity::class,
        ProfileEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        RoomTypeConverter::class
    ]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao(): AppDao
}