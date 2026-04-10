package com.noobaround.mangabrowser.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "manga",
    indices = [Index(value = ["folderUri"], unique = true)]
)
data class MangaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val folderUri: String,
    val coverPageUri: String,
    val pageCount: Int,
    val rootUri: String,
    val lastScannedAt: Long,
    val isAvailable: Boolean = true
)
