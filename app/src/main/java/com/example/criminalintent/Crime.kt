package com.example.criminalintent

import java.util.*


data class Crime (
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false
)

/*
UUID is a utility class included in the Android framework. It provides an easy way to generate
universally unique ID values. In the constructor, you generate a random unique ID by calling
UUID.randomUUID() .
 */