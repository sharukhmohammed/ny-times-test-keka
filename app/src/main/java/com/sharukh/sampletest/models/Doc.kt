package com.sharukh.sampletest.models

data class Docs(
    val docs: List<Doc>,
    // val meta: Any
)

data class Doc(
    val abstract: String, val source: String, val multimedia: List<Media> = listOf()
) {
    val image: Media?
        get() = multimedia.firstOrNull()
}

data class Media(var url: String)
