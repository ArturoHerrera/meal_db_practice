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
}