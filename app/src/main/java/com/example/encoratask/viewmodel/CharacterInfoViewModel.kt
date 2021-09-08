package com.example.encoratask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.encoratask.model.Character
import com.example.encoratask.repository.CharacterRepository

class CharacterInfoViewModel : ViewModel() {

    private lateinit var characterInfo: LiveData<Character>
    private var characterRepository: CharacterRepository

    init{
        characterRepository = CharacterRepository()

    }

    fun getCharacterInfo(character_id: Long): LiveData<Character> {
        characterInfo = characterRepository.getCharacterInfo(character_id)
        return characterInfo
    }

}