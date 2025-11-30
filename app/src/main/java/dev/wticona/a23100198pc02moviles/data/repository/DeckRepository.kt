package dev.wticona.a23100198pc02moviles.data.repository

import dev.wticona.a23100198pc02moviles.data.remote.RetrofitInstance

class DeckRepository {
// Clase para interactuar con la API de baraja de cartas
    suspend fun createDeck() =
        RetrofitInstance.api.createDeck()

    suspend fun drawCards(deckId: String, count: Int) =
        RetrofitInstance.api.drawCards(deckId, count)
}
