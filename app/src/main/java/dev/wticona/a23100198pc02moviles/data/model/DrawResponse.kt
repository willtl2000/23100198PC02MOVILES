package dev.wticona.a23100198pc02moviles.data.model

data class DrawResponse(
    val success: Boolean,
    val deck_id: String,
    val cards: List<CardModel>,
    val remaining: Int
)
