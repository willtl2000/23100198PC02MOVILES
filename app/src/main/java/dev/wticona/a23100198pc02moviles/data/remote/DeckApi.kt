package dev.wticona.a23100198pc02moviles.data.remote

import dev.wticona.a23100198pc02moviles.data.model.DeckResponse
import dev.wticona.a23100198pc02moviles.data.model.DrawResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DeckApi {

    @GET("api/deck/new/shuffle/")
    suspend fun createDeck(
        @Query("deck_count") deckCount: Int = 1
    ): DeckResponse

    @GET("api/deck/{deckId}/draw/")
    suspend fun drawCards(
        @Path("deckId") deckId: String,
        @Query("count") count: Int
    ): DrawResponse
}
