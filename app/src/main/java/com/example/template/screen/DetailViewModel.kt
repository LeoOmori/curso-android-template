package com.example.template.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.model.Post
import com.example.template.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface DetailUiState {
    data object Loading : DetailUiState
    data class Success(val post: Post) : DetailUiState
    data class Error(val message: String) : DetailUiState
}

class DetailViewModel(
    private val repository: PostRepository = PostRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun load(postId: Int) {
        _uiState.value = DetailUiState.Loading
        viewModelScope.launch {
            try {
                _uiState.value = DetailUiState.Success(repository.getPost(postId))
            } catch (e: Exception) {
                _uiState.value = DetailUiState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }
}
