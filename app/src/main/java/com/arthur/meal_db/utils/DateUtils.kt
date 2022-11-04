package com.arthur.meal_db.utils

object StringUtils {
    fun returnListFromWordSeparateBy(
        mWord: String?,
        delimiter: String = ","
    ): List<String> =
        mWord?.split(delimiter)?.map { it.trim().lowercase() } ?: listOf()
}