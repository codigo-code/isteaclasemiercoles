package edu.istea.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(var name: String, var pass: String) : Parcelable {
}