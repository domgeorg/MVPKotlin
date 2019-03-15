package gr.mobile.mvp.kotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SpeakerEvent(var speaker: Speaker, var photo:String) : Parcelable
