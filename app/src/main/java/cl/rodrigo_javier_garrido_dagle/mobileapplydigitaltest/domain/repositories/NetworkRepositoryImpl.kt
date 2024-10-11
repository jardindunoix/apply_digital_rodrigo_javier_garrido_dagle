package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.repositories

import android.util.Log
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.network.ApiCalls
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.network.dto.HitDto
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.utilities.Constants.TAG
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val apiCalls: ApiCalls
) : NetworkRepository {

    override suspend fun getAllHits(): List<HitDto>? {
        runCatching { apiCalls.getAllHit() }
            .onSuccess {
                return it.body()?.hits
            }
            .onFailure {
                Log.d(
                    TAG,
                    "There is an error in the api call::> ${it.message} ${it.localizedMessage} ${it.cause}"
                )
            }
        return null
    }

}