package com.orafaelsc.composeplayground.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ObserveStateViewModel : ViewModel() {

    private val loadingStateFlow = MutableStateFlow(false)
    fun loadingStateFlow(): StateFlow<Boolean> = loadingStateFlow

    fun setLoadingState(isLoading: Boolean) {
        viewModelScope.launch {
            loadingStateFlow.emit(isLoading)
        }
    }
}