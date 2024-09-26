package com.istea.modelo

import java.io.Serializable

data class Personaje(
    val name : String,
    val mass: String,
    val height: String,
    val hair_color :String,
    val skin_color: String,
    val eye_color: String,
    val birth_year: String,
    val gender: String,
    val homeworld: String) : Serializable
