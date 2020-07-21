package com.waichee.hiltpractice01.data.entities


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("results")
    val movies: List<Movie> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("total_results")
    val totalResults: Int = 0
)