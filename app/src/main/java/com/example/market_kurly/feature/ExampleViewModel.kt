package com.example.market_kurly.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.market_kurly.core.util.view.UiState
import com.example.market_kurly.domain.model.SignUpModel
import com.example.market_kurly.domain.repository.ExampleRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ExampleViewModel(
    private val exampleRepository: ExampleRepository,
) : ViewModel() {
    private val _signUpState = MutableLiveData<UiState>()
    val signUpState: LiveData<UiState> get() = _signUpState

    fun signUp(request: SignUpModel) {
        viewModelScope.launch {
            exampleRepository.signUp(request)
                .onSuccess {
                    _signUpState.value = UiState(true, "signUp 성공")
                }
                .onFailure {
                    if (it is HttpException) {
                        _signUpState.value = UiState(false, it.message())
                    } else {
                        _signUpState.value = UiState(false, "signUp 실패")
                    }
                }
        }
    }
}
