package com.noobaround.mangabrowser.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ReaderScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("阅读器") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "这里将接入真实页面列表与阅读进度恢复", style = MaterialTheme.typography.titleMedium)
            Text(text = "当前为 MVP 占位页，后续将加入：")
            Text(text = "1. 漫画页加载")
            Text(text = "2. 左到右 / 右到左模式")
            Text(text = "3. 自动恢复到上次页码")
            Text(text = "4. 退出时持久化阅读记录")
            Button(onClick = { navController.popBackStack() }) {
                Text("返回书库")
            }
        }
    }
}
