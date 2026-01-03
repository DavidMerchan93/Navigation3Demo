package com.davidmerchan.navigation3demo.hiltNavigation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltHomeViewModel @Inject constructor(
    private val repository: DemoRepository,
) : ViewModel() {
    val items = repository.items()
}

@HiltViewModel
class HiltDetailViewModel @Inject constructor(
    private val repository: DemoRepository,
) : ViewModel() {
    fun detailText(id: String): String = repository.detailText(id)
}
