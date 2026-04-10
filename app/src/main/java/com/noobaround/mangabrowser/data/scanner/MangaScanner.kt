package com.noobaround.mangabrowser.data.scanner

import android.net.Uri

data class ScannedPage(
    val fileName: String,
    val pageUri: String,
    val sortKey: Long?
)

data class ScannedManga(
    val title: String,
    val folderUri: String,
    val coverPageUri: String,
    val rootUri: String,
    val pages: List<ScannedPage>
)

data class ScanResult(
    val mangaList: List<ScannedManga>,
    val scannedAt: Long = System.currentTimeMillis()
)

interface MangaScanner {
    suspend fun scanRoot(rootUri: Uri): ScanResult
}
