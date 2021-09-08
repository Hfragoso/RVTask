package com.example.encoratask.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterInformationClient {
    private val BASE_URL = "https://rickandmortyapi.com/"

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInterface(): CharacterInformationInterface{
        return getRetrofit().create(CharacterInformationInterface::class.java)
    }

}