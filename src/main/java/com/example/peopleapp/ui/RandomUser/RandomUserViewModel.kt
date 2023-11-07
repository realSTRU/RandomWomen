package com.example.peopleapp.ui.RandomUser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.peopleapp.data.remote.dto.PersonDto
import com.example.peopleapp.data.repository.RandomPersonRepository
import com.example.peopleapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject


data class RandomUserListState(
    val isLoading : Boolean = false,
    val users : List<PersonDto> = emptyList(),
    val error : String = ""
)
@HiltViewModel
class RandomUserViewModel  @Inject constructor(
    private val repository : RandomPersonRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(RandomUserListState())
    val uiState : StateFlow<RandomUserListState> = _uiState.asStateFlow()

    init{
        repository.getRandomPerson().onEach { result ->
            when(result)
            {
                is Resource.Loading -> {
                    _uiState.update { it.copy(isLoading = true) }
                }
                is Resource.Success -> {
                    _uiState.update { it.copy(users =  result.data ?: emptyList()) }
                }
                is Resource.Error -> {
                    _uiState.update { it.copy(error = result.message ?: "Anonymous error") }
                }
            }
        }.launchIn(viewModelScope)
    }

}