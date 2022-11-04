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

        if (!strIngredient1.isNullOrEmpty() && !strMeasure1.isNullOrEmpty()) {
            mList.add("$strMeasure1 $strMeasure1")
        }

        if (!strIngredient2.isNullOrEmpty() && !strMeasure2.isNullOrEmpty()) {
            mList.add("$strIngredient2 $strMeasure2")
        }

        if (!strIngredient3.isNullOrEmpty() && !strMeasure3.isNullOrEmpty()) {
            mList.add("$strIngredient3 $strMeasure3")
        }

        if (!strIngredient4.isNullOrEmpty() && !strMeasure4.isNullOrEmpty()) {
            mList.add("$strIngredient4 $strMeasure4")
        }

        if (!strIngredient5.isNullOrEmpty() && !strMeasure5.isNullOrEmpty()) {
            mList.add("$strIngredient5 $strMeasure5")
        }

        if (!strIngredient6.isNullOrEmpty() && !strMeasure6.isNullOrEmpty()) {
            mList.add("$strIngredient6 $strMeasure6")
        }

        if (!strIngredient7.isNullOrEmpty() && !strMeasure7.isNullOrEmpty()) {
            mList.add("$strIngredient7 $strMeasure7")
        }

        if (!strIngredient8.isNullOrEmpty() && !strMeasure8.isNullOrEmpty()) {
            mList.add("$strIngredient8 $strMeasure8")
        }

        if (!strIngredient9.isNullOrEmpty() && !strMeasure9.isNullOrEmpty()) {
            mList.add("$strIngredient9 $strMeasure9")
        }

        if (!strIngredient10.isNullOrEmpty() && !strMeasure10.isNullOrEmpty()) {
            mList.add("$strIngredient10 $strMeasure10")
        }

        if (!strIngredient11.isNullOrEmpty() && !strMeasure11.isNullOrEmpty()) {
            mList.add("$strIngredient11 $strMeasure11")
        }

        if (!strIngredient12.isNullOrEmpty() && !strMeasure12.isNullOrEmpty()) {
            mList.add("$strIngredient12 $strMeasure12")
        }

        if (!strIngredient13.isNullOrEmpty() && !strMeasure13.isNullOrEmpty()) {
            mList.add("$strIngredient13 $strMeasure13")
        }

        if (!strIngredient14.isNullOrEmpty() && !strMeasure14.isNullOrEmpty()) {
            mList.add("$strIngredient14 $strMeasure14")
        }

        if (!strIngredient15.isNullOrEmpty() && !strMeasure15.isNullOrEmpty()) {
            mList.add("$strIngredient15 $strMeasure15")
        }

        if (!strIngredient16.isNullOrEmpty() && !strMeasure16.isNullOrEmpty()) {
            mList.add("$strIngredient16 $strMeasure16")
        }

        if (!strIngredient17.isNullOrEmpty() && !strMeasure17.isNullOrEmpty()) {
            mList.add("$strIngredient17 $strMeasure17")
        }

        if (!strIngredient18.isNullOrEmpty() && !strMeasure18.isNullOrEmpty()) {
            mList.add("$strIngredient18 $strMeasure18")
        }

        if (!strIngredient19.isNullOrEmpty() && !strMeasure19.isNullOrEmpty()) {
            mList.add("$strIngredient19 $strMeasure19")
        }

        if (!strIngredient20.isNullOrEmpty() && !strMeasure20.isNullOrEmpty()) {
            mList.add("$strIngredient20 $strMeasure20")
        }

        return mList
    }

}