package dev.wticona.a23100198pc02moviles.presentation.result

import androidx.lifecycle.ViewModel
import dev.wticona.a23100198pc02moviles.data.model.CardModel

class ResultViewModel : ViewModel() {

    fun calculatePlayerScore(values: List<Int>): Int =
        values.sum()

    fun generateDealerScore(): Int =
        (16..21).random()
}
