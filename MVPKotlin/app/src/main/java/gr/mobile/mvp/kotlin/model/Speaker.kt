package gr.mobile.mvp.kotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Speaker (
    val name: String,
    val title: String,
    val description: String
) : Parcelable