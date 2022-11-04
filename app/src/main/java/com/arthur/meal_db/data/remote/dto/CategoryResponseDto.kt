package com.arthur.meal_db.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CategoryResponseDto(
    @SerializedName("categories") var categories: List<Categories> = listOf()
)

data class Categories(
    @SerializedName("idCategory") var idCategory: String? = null,
    @SerializedName("strCategory") var strCategory: String? = null,
    @SerializedName("strCategoryThumb") var strCategoryThumb: String? = null,
    @SerializedName("strCategoryDescription") var strCategoryDescription: String? = null
)