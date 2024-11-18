package com.example.market_kurly.feature

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.market_kurly.data.ServicePool.exampleService
import com.example.market_kurly.data.dto.ResponseExampleDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExampleViewModel : ViewModel() {
    private val _exampleResponse: MutableLiveData<ResponseExampleDto> = MutableLiveData()
    val exampleResponse: MutableLiveData<ResponseExampleDto> = _exampleResponse

    // 기본
    private fun postExample1() {
        val call = exampleService.postExample1(requestExample = Unit)

        call.enqueue(object : Callback<ResponseExampleDto> {
            override fun onResponse(
                call: Call<ResponseExampleDto>,
                response: Response<ResponseExampleDto>
            ) {
                if (response.isSuccessful) {
                    _exampleResponse.value = response.body()
                } else {

                }
            }

            override fun onFailure(call: Call<ResponseExampleDto>, t: Throwable) {

            }
        })
    }

    // 코루틴
    private fun postExample2() = viewModelScope.launch {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = exampleService.postExample2(requestExample = Unit)
                _exampleResponse.value = response
            } catch (e: Exception) {

            }
        }
    }
}