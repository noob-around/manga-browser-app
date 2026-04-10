package com.noobaround.mangabrowser.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reading_progress")
data class ReadingProgressEntity(
    @PrimaryKey
    val mangaId: Long,
    val lastPageIndex: Int,
    val lastReadAt: Long
)
