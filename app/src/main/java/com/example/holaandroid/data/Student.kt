package com.example.holaandroid.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val name: String = "Anupam",
    val age: Int = 24
) : Parcelable