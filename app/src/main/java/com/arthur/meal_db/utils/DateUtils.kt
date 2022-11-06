package com.arthur.meal_db.utils

object StringUtils {
    fun returnListFromWordSeparateBy(
        mWord: String?,
        delimiter: String = ","
    ): List<String> =
        mWord?.split(delimiter)?.map { it.trim().lowercase() } ?: listOf()
}

object EmojiUtils {
    fun randomCook(): String =
        listOf(
            "\uD83D\uDC69\u200D\uD83C\uDF73",
            "\uD83D\uDC68\u200D\uD83C\uDF73"
        ).shuffled().first()

    fun getEmojiByCategory(category: String): String =
        when (category.lowercase()) {
            "beef" -> listOf("\uD83C\uDF56", "\uD83E\uDD69").shuffled().first()
            "chicken" -> "\uD83C\uDF57"
            "dessert" -> "\uD83E\uDD67"
            "lamb" -> "\uD83D\uDC11"
            "miscellaneous" -> "\uD83E\uDED5"
            "pasta" -> "\uD83C\uDF5D"
            "pork" -> "\uD83D\uDC16"
            "seafood" -> listOf("\uD83C\uDF64", "\uD83D\uDC19").shuffled().first()
            "side" -> "\uD83C\uDF72"
            "starter" -> "\uD83C\uDF2E"
            "vegan" -> "\uD83E\uDDC6"
            "vegetarian" -> "\uD83E\uDD57"
            "breakfast" -> "\uD83E\uDDC7"
            "goat" -> "\uD83D\uDC11"
            else -> "\uD83C\uDF74"
        }
}