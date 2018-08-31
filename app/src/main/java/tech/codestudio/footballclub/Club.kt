package tech.codestudio.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(
        val name: String,
        val image: String,
        val description: String
) : Parcelable