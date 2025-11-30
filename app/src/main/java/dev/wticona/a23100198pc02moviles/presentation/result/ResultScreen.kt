package dev.wticona.a23100198pc02moviles.presentation.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import coil.compose.rememberAsyncImagePainter

@Composable
fun ResultScreen(
    valuesString: String,
    imagesString: String,
    vm: ResultViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val values = valuesString.split("-").map { it.toInt() }
    val images = imagesString.split("|")

    val playerScore = vm.calculatePlayerScore(values)
    val dealerScore = vm.generateDealerScore()

    val result = when {
        playerScore > 21 -> "Perdiste"
        dealerScore > 21 -> "¡Ganaste!"
        playerScore > dealerScore -> "¡Ganaste!"
        dealerScore > playerScore -> "Perdiste"
        else -> "Empate"
    }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Resultado") }) }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Tus cartas:")
            Spacer(Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                images.forEach { url ->
                    Image(
                        painter = rememberAsyncImagePainter(url),
                        contentDescription = null,
                        modifier = Modifier.size(120.dp)
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Text("Puntaje del jugador: $playerScore")
            Text("Puntaje de la máquina: $dealerScore")

            Spacer(Modifier.height(24.dp))

            Text(
                result,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
