package com.cubetiqs.common.utils.string

import com.cubetiqs.common.static.Constants

fun String?.getOrEmpty(defaultValue: String = ""): String {
    if (this.isNullOrEmpty()) return defaultValue
    return this
}

fun String?.ifEmptyNull(): String? {
    if (this.isNullOrEmpty()) return null
    return this
}

fun Any?.asString(defaultValue: String = ""): String {
    if (this == null) return defaultValue
    if (this is String) return this
    return this.toString()
}

fun String?.getAndPlus(text: String = ""): String {
    if (this == null) return text
    return this.plus(text)
}

fun String?.addDeletedText(): String? {
    if (this == null) return null
    return this.plus(Constants.DELETED_TEXT)
}

fun String?.minusDeletedText(): String? {
    if (this == null) return null
    return this.split("-")[0].trim()
}

fun String?.querySearch(prefix: String = "%", suffix: String = "%"): String {
    return "$prefix${this?.toLowerCase()?.trim()}$suffix"
}

private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

fun String?.randomString(): String {
    val strLen = this?.length ?: 2
    return (1..strLen)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")
}

fun String.toMutableSet(splitter: Char): Set<String> = this.trim().split(splitter).toMutableSet()

fun String.isAllCaps(): Boolean = !this.matches(Regex(".*[a-z].*"))

/**
 * Replace space with underscore and to upper case.
 */
fun String.fromSpaceToUnderScoreAndUpperCase() = this.replace(' ', '_').toUpperCase()