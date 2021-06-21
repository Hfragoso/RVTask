package com.example.encoratask.repository.network

import com.example.encoratask.model.Character

data class CharacterResponse(
    val info : PageInfo,
    val results : List<Character>
)