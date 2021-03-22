package com.robosh.basestartapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val id: String,
    val imageUrl: String
) : Parcelable