package com.arthur.meal_db.data.model

import com.arthur.meal_db.utils.StringUtils

class MealDetailSimple private constructor(
    val mealName: String = "",
    val mealId: String = "",
    val drinkAlternate: String = "",
    val category: String = "",
    val area: String = "",
    val instructions: String = "",
    val mealThumb: String = "",
    val tags: List<String> = listOf(),
    val urlYoutube: String = "",
    val ingredientList: List<String> = listOf(),
    val source: String = "",
    val imgSource: String = "",
) {
    data class Builder(
        var mealName: String = "",
        var mealId: String = "",
        var drinkAlternate: String = "",
        var category: String = "",
        var area: String = "",
        var instructions: String = "",
        var mealThumb: String = "",
        var tags: List<String> = listOf(),
        var urlYoutube: String = "",
        var ingredientList: List<String> = listOf(),
        var source: String = "",
        var imgSource: String = "",
    ) {
        fun setMealName(name: String?) =
            apply { this.mealName = name ?: "--" }

        fun setMealId(mealId: String?) =
            apply { this.mealId = mealId ?: "--" }

        fun setDrinkAlternate(drinkAlternate: String?) =
            apply { this.drinkAlternate = drinkAlternate ?: "--" }

        fun setCategory(category: String?) =
            apply { this.category = category ?: "--" }

        fun setArea(area: String?) =
            apply { this.area = area ?: "--" }

        fun setInstructions(instructions: String?) =
            apply { this.instructions = instructions ?: "--" }

        fun setMealThumb(mealThumb: String?) =
            apply { this.mealThumb = mealThumb ?: "--" }

        fun setTags(tags: String?) =
            apply { this.tags = StringUtils.returnListFromWordSeparateBy(tags, ",") }

        fun setUrlYoutube(urlYoutube: String?) =
            apply { this.urlYoutube = urlYoutube ?: "--" }

        fun setIngredientList(ingredientList: List<String>) =
            apply { this.ingredientList = ingredientList }

        fun setSource(source: String?) =
            apply { this.source = source ?: "--" }

        fun setImgSource(imgSource: String?) =
            apply { this.imgSource = imgSource ?: "--" }

        fun build() = MealDetailSimple(
            mealName = mealName,
            mealId = mealId,
            drinkAlternate = drinkAlternate,
            category = category,
            area = area,
            instructions = instructions,
            mealThumb = mealThumb,
            tags = tags,
            urlYoutube = urlYoutube,
            ingredientList = ingredientList,
            source = source,
            imgSource = imgSource
        )
    }
}

data class MealDetail(
    val errorMessage: String? = null,
    val mealDetail: MealDetailSimple? = null
)