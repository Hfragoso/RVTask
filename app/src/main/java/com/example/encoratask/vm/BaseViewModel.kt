package com.example.encoratask.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.encoratask.model.Character
import com.example.encoratask.repository.APICharacterImpl
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class BaseViewModel : ViewModel() {

    @Inject
    lateinit var api: APICharacterImpl

    private val _listCharacter by lazy {
        MutableLiveData<List<Character>>()
    }

    val listCharacter: LiveData<List<Character>> = _listCharacter

    fun getItems(){
        viewModelScope.launch {
            api.getData().collect {
                _listCharacter.value = it
            }
        }
    }
}