package dev.wticona.a23100198pc02moviles.data.model

data class DeckResponse(
    val success: Boolean,
    val deck_id: String,
    val remaining: Int,
    val shuffled: Boolean
)
