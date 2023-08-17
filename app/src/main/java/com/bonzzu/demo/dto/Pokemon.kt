package com.bonzzu.demo.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDto(
var name:String,
var gameIndexes: Indices,
)

@JsonClass(generateAdapter = true)
data class Indices(var index:String)
