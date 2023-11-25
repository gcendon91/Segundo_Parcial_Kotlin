package com.gcendon.a2doparcial

import android.media.Image
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Fruit(
    val name: String,
    val id: Long,
    val nutritions: Nutritions
) : Parcelable

@Parcelize
data class Nutritions(
    val calories: Long,
    val fat: Double,
    val sugar: Double,
    val carbohydrates: Double,
    val protein: Double
) : Parcelable
