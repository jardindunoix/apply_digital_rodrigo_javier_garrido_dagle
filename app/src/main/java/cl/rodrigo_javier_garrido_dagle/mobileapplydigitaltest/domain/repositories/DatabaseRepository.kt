package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.repositories

import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.database.entities.HitEntity

interface DatabaseRepository {

    suspend fun getAllHits(): List<HitEntity>?
    suspend fun insertAllHits(hits: List<HitEntity>?)
    suspend fun insertHit(hit: HitEntity)
}