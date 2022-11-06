package com.arthur.meal_db.data.model

class MealCoverSimple private constructor(
    val mealId: String? = null,
    val mealName: String? = null,
    val mealImageUrl: String? = null
) {
    data class Builder(
        var mealId: String? = null,
        var mealName: String? = null,
        var mealImageUrl: String? = null
    ) {
        fun setMealId(mealId: String?) =
            apply { this.mealId = mealId ?: "-1" }

        fun setMealName(mealName: String?) =
            apply { this.mealName = mealName ?: "--" }

        fun setMealImageUrl(mealImageUrl: String?) =
            apply { this.mealImageUrl = mealImageUrl ?: "--" }

        fun build() = MealCoverSimple(
            mealId = mealId,
            mealName = mealName,
            mealImageUrl = mealImageUrl
        )
    }
}

data class MealCoverList(
    val errorMessage: String? = null,
    val mealCoverSimpleList: List<MealCoverSimple>
)