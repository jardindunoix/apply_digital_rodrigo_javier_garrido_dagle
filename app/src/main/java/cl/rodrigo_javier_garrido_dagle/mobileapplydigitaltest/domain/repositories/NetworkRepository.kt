package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.repositories

import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.network.dto.HitDto

interface NetworkRepository {

   suspend fun getAllHits(): List<HitDto>?
}