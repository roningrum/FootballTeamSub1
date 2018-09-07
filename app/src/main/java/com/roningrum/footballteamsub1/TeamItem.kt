package com.roningrum.footballteamsub1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamItem(val name: String?, val image:Int, val desc: String?): Parcelable