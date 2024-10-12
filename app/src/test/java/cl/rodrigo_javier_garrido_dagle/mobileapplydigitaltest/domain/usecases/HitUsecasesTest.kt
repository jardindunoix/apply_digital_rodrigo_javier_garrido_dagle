package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.usecases

import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.repositories.DatabaseRepositoryImpl
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.repositories.NetworkRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class HitUsecasesTest {

    @RelaxedMockK
    private lateinit var networkRepositoryImpl: NetworkRepositoryImpl
    @RelaxedMockK
    private lateinit var databaseRepositoryImpl: DatabaseRepositoryImpl
    private lateinit var hitUsecases: HitUsecases

    @Before
    fun onBefore() {
        // initializations
        MockKAnnotations.init(this)
        hitUsecases = HitUsecases(networkRepositoryImpl, databaseRepositoryImpl)
    }

    @Test
    fun `when database return empty list then the webscrap is called`(): Unit = runBlocking {
//GIVEN
        coEvery { databaseRepositoryImpl.getAllHits() } returns emptyList()
//WHEN
        hitUsecases()
//THEN
        coVerify(exactly = 1) { networkRepositoryImpl.getAllHits() }
    }
}