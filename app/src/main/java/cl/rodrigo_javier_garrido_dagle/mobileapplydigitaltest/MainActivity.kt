package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.model.Hit
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.navigation.AppNavigation
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.theme.MobileApplyDigitalTestTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val hits: List<Hit> = viewModel.getAllHits()
            setContent {
                MobileApplyDigitalTestTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppNavigation(
                            viewModel,
                            hits
                        )
                    }
                }
            }
        }
    }
}
