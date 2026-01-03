package com.davidmerchan.navigation3demo.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.davidmerchan.navigation3demo.ui.theme.Navigation3DemoTheme

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text("Error Screen")
        }
    }
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    Navigation3DemoTheme {
        ErrorScreen()
    }
}
