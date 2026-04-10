package com.noobaround.mangabrowser.data.local.entity

import androidx.room.Entity

@Entity(
    tableName = "gallery_manga_cross_ref",
    primaryKeys = ["galleryId", "mangaId"]
)
data class GalleryMangaCrossRefEntity(
    val galleryId: Long,
    val mangaId: Long,
    val orderIndex: Int,
    val addedAt: Long
)
