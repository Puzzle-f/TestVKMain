package com.example.testvk.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseVK(
    @Expose
    val items: List<String>
): Parcelable