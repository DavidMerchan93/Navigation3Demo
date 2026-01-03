package com.davidmerchan.navigation3demo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidmerchan.navigation3demo.ui.theme.Navigation3DemoTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier, id: String, onBack: () -> Unit) {
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
            Text("Detail Screen")
            Text("ID: $id")
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = onBack) {
                Text("Volver")
            }
        }
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    Navigation3DemoTheme {
        DetailScreen(id = "1", onBack = {})
    }
}
