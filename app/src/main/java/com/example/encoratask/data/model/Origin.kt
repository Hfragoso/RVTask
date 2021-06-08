package com.example.encoratask.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class Origin(
    val name: String,
    val url: String
) : Parcelable
