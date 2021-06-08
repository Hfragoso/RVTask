package com.example.encoratask.data.network

import com.example.encoratask.data.model.RickMortyCharacterDetail
import com.example.encoratask.data.model.RickMortyCharacters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickMortyApi {

    @GET("/api/character/")
    suspend fun getCharacters(): Response<RickMortyCharacters>

    @GET("/api/character/{character_id}")
    suspend fun getCharacterDetail(@Path("character_id") characterId: Int): Response<RickMortyCharacterDetail>

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}