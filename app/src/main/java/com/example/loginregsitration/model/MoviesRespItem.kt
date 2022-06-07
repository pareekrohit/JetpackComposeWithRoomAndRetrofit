package com.example.loginregsitration.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MoviesRespItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val Poster: String? = "",
    val Runtime: String? = "",
    val Title: String? = "",
    val Year: String? = "",
    val isLike: Boolean = false
)