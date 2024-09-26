package com.istea.modelo

import java.io.Serializable

data class User(var nombre: String,
                var pass:String,
                var email:String,
                var tel : String,
                var fechaNacimiento:String,
                var sexo: String,
                var fumar: Boolean,
                var rol: String
                ): Serializable