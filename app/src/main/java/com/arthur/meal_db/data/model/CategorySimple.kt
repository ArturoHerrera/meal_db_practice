package com.arthur.meal_db.data.model


class CategorySimple private constructor(
    val idCategory: String? = null,
    val category: String? = null,
    val categoryThumb: String? = null,
    val categoryDescription: String? = null
) {
    data class Builder(
        var idCategory: String? = null,
        var category: String? = null,
        var categoryThumb: String? = null,
        var categoryDescription: String? = null
    ) {
        fun setId(id: String?) =
            apply { this.idCategory = id ?: "-1" }

        fun setCategory(category: String?) =
            apply { this.category = category ?: "--" }

        fun setCategoryThumb(categoryThumb: String?) =
            apply { this.categoryThumb = categoryThumb ?: "--" }

        fun setCategoryDescription(categoryDescription: String?) =
            apply { this.categoryDescription = categoryDescription ?: "--" }

        fun build() = CategorySimple(
            idCategory = idCategory,
            category = category,
            categoryThumb = categoryThumb,
            categoryDescription = categoryDescription
        )
    }
}

data class CategoryList(
    val errorMessage: String? = null,
    val categorySimpleList: List<CategorySimple>
)