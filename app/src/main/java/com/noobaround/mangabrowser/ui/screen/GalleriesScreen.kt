package com.noobaround.mangabrowser.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun GalleriesScreen(navController: NavController) {
    val galleries = listOf("收藏", "待看", "长篇", "战斗类")

    Scaffold(
        topBar = { TopAppBar(title = { Text("虚拟画廊") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Text("+")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(galleries) { galleryName ->
                Card(modifier = Modifier.fillParentMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = galleryName, style = MaterialTheme.typography.titleMedium)
                        Text(text = "后续接入 Room 后支持创建、重命名、删除和排序")
                    }
                }
            }
        }
    }
}
