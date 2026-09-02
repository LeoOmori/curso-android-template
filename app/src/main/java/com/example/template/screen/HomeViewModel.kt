package com.example.template.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.model.Post
import com.example.template.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Estados possíveis da tela de lista.
 * `sealed interface` deixa o `when` exaustivo na UI.
 */
sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val posts: List<Post>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}

/**
 * Guarda o estado da tela e sobrevive a mudanças de configuração
 * (ex.: girar o celular). A UI apenas observa `uiState`.
 */
class HomeViewModel(
    private val repository: PostRepository = PostRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        _uiState.value = HomeUiState.Loading
        viewModelScope.launch {
            try {
                val posts = repository.listPosts()
                _uiState.value = HomeUiState.Success(posts)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "Erro desconhecido")
            }
        }
    }
}
