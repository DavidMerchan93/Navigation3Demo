package com.davidmerchan.navigation3demo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidmerchan.navigation3demo.ui.theme.Navigation3DemoTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onNavigateToDetail: (String) -> Unit) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(10) { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            onNavigateToDetail(item.toString())
                        }

                ) {
                    Text("Item $item")
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    Navigation3DemoTheme {
        HomeScreen(onNavigateToDetail = {})
    }
}
