package com.arthur.meal_db.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MealDetailResponseDto(
    @SerializedName("meals") var meals: List<MealsDto> = listOf()
)

data class MealsDto(
    @SerializedName("idMeal") var idMeal: String? = null,
    @SerializedName("strMeal") var strMeal: String? = null,
    @SerializedName("strDrinkAlternate") var strDrinkAlternate: String? = null,
    @SerializedName("strCategory") var strCategory: String? = null,
    @SerializedName("strArea") var strArea: String? = null,
    @SerializedName("strInstructions") var strInstructions: String? = null,
    @SerializedName("strMealThumb") var strMealThumb: String? = null,
    @SerializedName("strTags") var strTags: String? = null,
    @SerializedName("strYoutube") var strYoutube: String? = null,
    @SerializedName("strIngredient1") var strIngredient1: String? = null,
    @SerializedName("strIngredient2") var strIngredient2: String? = null,
    @SerializedName("strIngredient3") var strIngredient3: String? = null,
    @SerializedName("strIngredient4") var strIngredient4: String? = null,
    @SerializedName("strIngredient5") var strIngredient5: String? = null,
    @SerializedName("strIngredient6") var strIngredient6: String? = null,
    @SerializedName("strIngredient7") var strIngredient7: String? = null,
    @SerializedName("strIngredient8") var strIngredient8: String? = null,
    @SerializedName("strIngredient9") var strIngredient9: String? = null,
    @SerializedName("strIngredient10") var strIngredient10: String? = null,
    @SerializedName("strIngredient11") var strIngredient11: String? = null,
    @SerializedName("strIngredient12") var strIngredient12: String? = null,
    @SerializedName("strIngredient13") var strIngredient13: String? = null,
    @SerializedName("strIngredient14") var strIngredient14: String? = null,
    @SerializedName("strIngredient15") var strIngredient15: String? = null,
    @SerializedName("strIngredient16") var strIngredient16: String? = null,
    @SerializedName("strIngredient17") var strIngredient17: String? = null,
    @SerializedName("strIngredient18") var strIngredient18: String? = null,
    @SerializedName("strIngredient19") var strIngredient19: String? = null,
    @SerializedName("strIngredient20") var strIngredient20: String? = null,
    @SerializedName("strMeasure1") var strMeasure1: String? = null,
    @SerializedName("strMeasure2") var strMeasure2: String? = null,
    @SerializedName("strMeasure3") var strMeasure3: String? = null,
    @SerializedName("strMeasure4") var strMeasure4: String? = null,
    @SerializedName("strMeasure5") var strMeasure5: String? = null,
    @SerializedName("strMeasure6") var strMeasure6: String? = null,
    @SerializedName("strMeasure7") var strMeasure7: String? = null,
    @SerializedName("strMeasure8") var strMeasure8: String? = null,
    @SerializedName("strMeasure9") var strMeasure9: String? = null,
    @SerializedName("strMeasure10") var strMeasure10: String? = null,
    @SerializedName("strMeasure11") var strMeasure11: String? = null,
    @SerializedName("strMeasure12") var strMeasure12: String? = null,
    @SerializedName("strMeasure13") var strMeasure13: String? = null,
    @SerializedName("strMeasure14") var strMeasure14: String? = null,
    @SerializedName("strMeasure15") var strMeasure15: String? = null,
    @SerializedName("strMeasure16") var strMeasure16: String? = null,
    @SerializedName("strMeasure17") var strMeasure17: String? = null,
    @SerializedName("strMeasure18") var strMeasure18: String? = null,
    @SerializedName("strMeasure19") var strMeasure19: String? = null,
    @SerializedName("strMeasure20") var strMeasure20: String? = null,
    @SerializedName("strSource") var strSource: String? = null,
    @SerializedName("strImageSource") var strImageSource: String? = null,
    @SerializedName("strCreativeCommonsConfirmed") var strCreativeCommonsConfirmed: String? = null,
    @SerializedName("dateModified") var dateModified: String? = null
) {

    fun getIngredientList(): List<String> {

        val mList = arrayListOf<String>()

        if (!strMeasure1.isNullOrEmpty() && !strIngredient1.isNullOrEmpty()) {
            mList.add("$strMeasure1 $strIngredient1")
        }

        if (!strMeasure2.isNullOrEmpty() && !strIngredient2.isNullOrEmpty()) {
            mList.add("$strMeasure2 $strIngredient2")
        }

        if (!strMeasure3.isNullOrEmpty() && !strIngredient3.isNullOrEmpty()) {
            mList.add("$strMeasure3 $strIngredient3")
        }

        if (!strMeasure4.isNullOrEmpty() && !strIngredient4.isNullOrEmpty()) {
            mList.add("$strMeasure4 $strIngredient4")
        }

        if (!strMeasure5.isNullOrEmpty() && !strIngredient5.isNullOrEmpty()) {
            mList.add("$strMeasure5 $strIngredient5")
        }

        if (!strMeasure6.isNullOrEmpty() && !strIngredient6.isNullOrEmpty()) {
            mList.add("$strMeasure6 $strIngredient6")
        }

        if (!strMeasure7.isNullOrEmpty() && !strIngredient7.isNullOrEmpty()) {
            mList.add("$strMeasure7 $strIngredient7")
        }

        if (!strMeasure8.isNullOrEmpty() && !strIngredient8.isNullOrEmpty()) {
            mList.add("$strMeasure8 $strIngredient8")
        }

        if (!strMeasure9.isNullOrEmpty() && !strIngredient9.isNullOrEmpty()) {
            mList.add("$strMeasure9 $strIngredient9")
        }

        if (!strMeasure10.isNullOrEmpty() && !strIngredient10.isNullOrEmpty()) {
            mList.add("$strMeasure10 $strIngredient10")
        }

        if (!strMeasure11.isNullOrEmpty() && !strIngredient11.isNullOrEmpty()) {
            mList.add("$strMeasure11 $strIngredient11")
        }

        if (!strMeasure12.isNullOrEmpty() && !strIngredient12.isNullOrEmpty()) {
            mList.add("$strMeasure12 $strIngredient12")
        }

        if (!strMeasure13.isNullOrEmpty() && !strIngredient13.isNullOrEmpty()) {
            mList.add("$strMeasure13 $strIngredient13")
        }

        if (!strMeasure14.isNullOrEmpty() && !strIngredient14.isNullOrEmpty()) {
            mList.add("$strMeasure14 $strIngredient14")
        }

        if (!strMeasure15.isNullOrEmpty() && !strIngredient15.isNullOrEmpty()) {
            mList.add("$strMeasure15 $strIngredient15")
        }

        if (!strMeasure16.isNullOrEmpty() && !strIngredient16.isNullOrEmpty()) {
            mList.add("$strMeasure16 $strIngredient16")
        }

        if (!strMeasure17.isNullOrEmpty() && !strIngredient17.isNullOrEmpty()) {
            mList.add("$strMeasure17 $strIngredient17")
        }

        if (!strMeasure18.isNullOrEmpty() && !strIngredient18.isNullOrEmpty()) {
            mList.add("$strMeasure18 $strIngredient18")
        }

        if (!strMeasure19.isNullOrEmpty() && !strIngredient19.isNullOrEmpty()) {
            mList.add("$strMeasure19 $strIngredient19")
        }

        if (!strMeasure20.isNullOrEmpty() && !strIngredient20.isNullOrEmpty()) {
            mList.add("$strMeasure20 $strIngredient20")
        }

        return mList
    }

}