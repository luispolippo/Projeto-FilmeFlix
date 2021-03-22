package com.polippo.filmesflix.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val titulo: String,
    val descricao: String?,
    val imagem: String?,
    @SerializedName("data_lancamento")
    val dataLancamento: String?
): Parcelable
