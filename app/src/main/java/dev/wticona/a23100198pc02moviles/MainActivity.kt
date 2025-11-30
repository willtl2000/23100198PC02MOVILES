package dev.wticona.a23100198pc02moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.wticona.a23100198pc02moviles.presentation.navigation.AppNavGraph
import dev.wticona.a23100198pc02moviles.ui.theme._23100198PC02MOVILESTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _23100198PC02MOVILESTheme {
                AppNavGraph()
            }
        }
    }
}
