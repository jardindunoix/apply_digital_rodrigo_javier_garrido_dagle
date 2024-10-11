package cl.rodrigo_javier_garrido_dagle.mobiledevtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import cl.rodrigo_javier_garrido_dagle.mobiledevtest.domain.model.Hit
import cl.rodrigo_javier_garrido_dagle.mobiledevtest.domain.repositories.ConnectivityRepository
import cl.rodrigo_javier_garrido_dagle.mobiledevtest.domain.usecases.HitUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    connectivityRepository: ConnectivityRepository,
    private val networkUsecases: HitUsecases,
) : ViewModel() {
    private val isOnline = connectivityRepository.isConnected.asLiveData()
    private val _isLoading = MutableStateFlow(false)
    var isLoading = _isLoading.asStateFlow()

    init {
        loading()
    }

    private fun loading() {
        viewModelScope.launch {
            _isLoading.value = true
            getAllHits()
            delay(1000)
            _isLoading.value = false
        }
    }

    suspend fun getAllHits(): List<Hit> {
        return if (isOnline.value!!) {
            networkUsecases.invoke()
        } else {
            networkUsecases.invokeOffLine()
        }
    }
}