package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.database.entities.HitEntity

@Dao
interface HitsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllData(list: List<HitEntity>)

    @Query("SELECT * FROM hit ORDER BY created_at_id DESC")
    suspend fun getAllData(): List<HitEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHit(hit: HitEntity) {

    }
}