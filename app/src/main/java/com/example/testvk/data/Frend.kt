package com.example.testvk.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Frend(
    @SerializedName("first_name")
    @Expose
    val first_name: String,
    @SerializedName("last_name")
    @Expose
    val last_name: String
): Parcelable