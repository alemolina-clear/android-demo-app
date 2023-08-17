package com.bonzzu.demo.api

import com.bonzzu.demo.dto.PokemonDto
import retrofit2.http.GET
import retrofit2.http.Query

interface DemoApi {
  companion object {
    const val BASE = "https://pokeapi.co/api/v2/"
    const val POK = "pokemon/2"
  }

  @GET( POK)
  suspend fun getBaseData(): PokemonDto
}