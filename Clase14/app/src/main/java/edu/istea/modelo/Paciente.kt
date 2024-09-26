package edu.istea.modelo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Paciente(var nombre:String, var comida1:String, var comida2:String, var postreNombre: String, var foto:Int) : Parcelable