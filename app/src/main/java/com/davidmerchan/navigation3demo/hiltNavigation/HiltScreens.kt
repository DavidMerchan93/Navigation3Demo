package com.davidmerchan.navigation3demo.hiltNavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HiltHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HiltHomeViewModel = hiltViewModel(),
    onNavigateToDetail: (String) -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(viewModel.items.size) { index ->
                val itemId = viewModel.items[index].removePrefix("Item ").trim()
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable { onNavigateToDetail(itemId) },
                    text = viewModel.items[index],
                )
            }
        }
    }
}

@Composable
fun HiltDetailScreen(
    modifier: Modifier = Modifier,
    id: String,
    viewModel: HiltDetailViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hilt Detail Screen")
            Text("ID: $id")
            Text(viewModel.detailText(id))
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = onBack) {
                Text("Volver")
            }
        }
    }
}
