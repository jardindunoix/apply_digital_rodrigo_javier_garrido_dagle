@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.model.Hit
import cl.rodrigo_javier_garrido_dagle.mobiledevtest.MainViewModel
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.screens.components.ColumnItem
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.screens.components.SwipeToDeleteContainer
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainListScreen(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
    hitsY: List<Hit>
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isLoading)

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { viewModel.isLoading },
        indicator = { state, refreshTriugger ->
            SwipeRefreshIndicator(state = state, refreshTriggerDistance = refreshTriugger)
        }
    ) {

        val hits = hitsY.toMutableStateList()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
//            contentPadding = PaddingValues(0.dp),
        ) {
            items(
                items = hits,
                key = { Gson().toJson(it) }
            ) { hit ->

                SwipeToDeleteContainer(
                    item = hit,
                    onDelete = {
                        hits -= hit
                    }
                ) { innerHit ->
                    ColumnItem(
                        modifier,
                        hit = innerHit,
                        navController = navController,
                    )
                }
            }
        }
    }
}
