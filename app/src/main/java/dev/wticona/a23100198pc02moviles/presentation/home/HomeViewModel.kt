package dev.wticona.a23100198pc02moviles.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.wticona.a23100198pc02moviles.data.repository.DeckRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repo = DeckRepository()

    fun drawCards(
        count: Int,
        onReady: (List<Int>, List<String>) -> Unit
    ) {
        viewModelScope.launch {

            val deck = repo.createDeck()
            val draw = repo.drawCards(deck.deck_id, count)

            val values = draw.cards.map { card ->
                when (card.value) {
                    "ACE" -> 11
                    "KING", "QUEEN", "JACK" -> 10
                    else -> card.value.toIntOrNull() ?: 0
                }
            }

            val images = draw.cards.map { it.image }

            onReady(values, images)
        }
    }
}
