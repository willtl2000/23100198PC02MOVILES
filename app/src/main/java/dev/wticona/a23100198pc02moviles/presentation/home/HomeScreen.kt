package dev.wticona.a23100198pc02moviles.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.wticona.a23100198pc02moviles.presentation.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(nav: NavController, vm: HomeViewModel = viewModel()) {

    var count by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Blackjack – PC02") })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = count,
                onValueChange = { count = it },
                label = { Text("Número de cartas (2–5)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    vm.drawCards(count.toInt()) { values, images ->
                        val valuesString = values.joinToString("-")
                        val imagesString = images.joinToString("|")
                        nav.navigate("${Routes.Result}/$valuesString/$imagesString")
                    }
                },
                enabled = count.toIntOrNull() in 2..5,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Jugar")
            }
        }
    }
}
