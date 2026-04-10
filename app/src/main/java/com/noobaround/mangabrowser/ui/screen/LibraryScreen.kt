package com.noobaround.mangabrowser.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.noobaround.mangabrowser.ui.AppDestination

private data class MangaCardUiModel(
    val id: Long,
    val title: String,
    val pageCount: Int,
    val progressText: String
)

@Composable
fun LibraryScreen(navController: NavController) {
    val items = listOf(
        MangaCardUiModel(1, "示例漫画 A", 128, "阅读到第 23 页"),
        MangaCardUiModel(2, "示例漫画 B", 56, "未开始"),
        MangaCardUiModel(3, "示例漫画 C", 207, "阅读到第 101 页")
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("本地漫画书库") })
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items) { manga ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate(AppDestination.Reader.route) }
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = manga.title,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "页数：${manga.pageCount}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = manga.progressText,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}
