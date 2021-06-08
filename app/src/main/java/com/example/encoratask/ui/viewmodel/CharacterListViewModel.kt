package com.example.encoratask.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.encoratask.data.model.RickMortyCharacterDetail
import com.example.encoratask.data.network.RickMortyService
import com.example.encoratask.data.network.response.RickMortyApiResponse
import kotlinx.coroutines.launch
import java.io.IOException

class CharacterListViewModel : ViewModel() {
    val characterList: MutableLiveData<List<RickMortyCharacterDetail>> =
        MutableLiveData<List<RickMortyCharacterDetail>>()

    val errorMessage: MutableLiveData<String> = MutableLiveData("")

    fun onCreate() {
        viewModelScope.launch {

            handleResult(loadCharacters())
        }
    }

    private suspend fun loadCharacters(): RickMortyApiResponse {
        val rickMortyService = RickMortyService().getClient()
        return try {
            val response = rickMortyService.getCharacters()
            if (response.isSuccessful) {
                RickMortyApiResponse.Success(response.body()!!)
            } else {
                RickMortyApiResponse.Error(response.message())
            }
        } catch (error: IOException) {
            RickMortyApiResponse.Error(error.message!!)
        }
    }

    private fun handleResult(result: RickMortyApiResponse) {
        when (result) {
            is RickMortyApiResponse.Error -> handleError(result.error)
            is RickMortyApiResponse.Success -> handleSuccess(result.data.results)
        }
    }

    private fun handleSuccess(results: List<RickMortyCharacterDetail>) {
        characterList.postValue(results)
    }

    private fun handleError(error: String) {
        errorMessage.postValue(error)
    }
}
