package com.example.encoratask.repository.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface APICharacter {

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com"
    }

    @GET("/api/character/")
    fun getCharacters(): Single<CharacterResponse>
}