package com.example.encoratask.networking

import com.example.encoratask.model.Character
import com.example.encoratask.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterInformationInterface {
    //TODO - Add a parameter to load by page
    @GET("api/character")
    fun getAllCharacters(): Call<CharacterList>

    @GET("api/character/{character_id}")
    fun getCharacterInfo(@Path("character_id") character_id:Long): Call<Character>

}