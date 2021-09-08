package com.example.encoratask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.encoratask.model.CharacterList
import com.example.encoratask.repository.CharacterRepository

class CharacterListViewModel() : ViewModel() {

    private var characterList: LiveData<CharacterList>
    private var characterRepository: CharacterRepository

    init{
        characterRepository = CharacterRepository()
        characterList = characterRepository.getCharactersList()
    }

    fun getCharacterList(): LiveData<CharacterList>{
        return characterList
    }

}