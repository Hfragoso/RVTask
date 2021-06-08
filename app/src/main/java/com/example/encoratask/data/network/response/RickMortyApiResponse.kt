package com.example.encoratask.data.network.response

import com.example.encoratask.data.model.RickMortyCharacters

sealed class RickMortyApiResponse {
    data class Success(val data: RickMortyCharacters) : RickMortyApiResponse()
    data class Error(val error: String) : RickMortyApiResponse()
}