package com.plznoanr.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plznoanr.domain.model.Search

@Entity
data class SearchEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val date: String
) {
    fun toDomain() = Search(
        name = name,
        date = date
    )
}