package com.example.encoratask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.encoratask.model.Character
import com.example.encoratask.model.CharacterList
import com.example.encoratask.networking.CharacterInformationClient
import com.example.encoratask.networking.CharacterInformationInterface
import retrofit2.Call
import retrofit2.Response

class CharacterRepository {
    private var characterInterface: CharacterInformationInterface
    private lateinit var characterListLiveData: MutableLiveData<CharacterList>
    private lateinit var characterInfoLiveData: MutableLiveData<Character>

    init{
        characterInterface = CharacterInformationClient().getInterface()
    }

    fun getCharactersList(): LiveData<CharacterList>{
        characterListLiveData = MutableLiveData()
        val charactersList = characterInterface.getAllCharacters()
        charactersList.enqueue(object : retrofit2.Callback<CharacterList>{
            override fun onResponse(call: Call<CharacterList>, response: Response<CharacterList>) {
                characterListLiveData.value = response.body()
            }

            override fun onFailure(call: Call<CharacterList>, t: Throwable) {
               Log.e("ERROR", "Error")
            }

        })

        return characterListLiveData
    }

    fun getCharacterInfo(id: Long): LiveData<Character>{
        characterInfoLiveData = MutableLiveData()
        val charactersList = characterInterface.getCharacterInfo(id)
        charactersList.enqueue(object : retrofit2.Callback<Character>{
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                characterInfoLiveData.value = response.body()
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.e("ERROR", "Error")
            }

        })

        return characterInfoLiveData
    }
}