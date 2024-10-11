package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.database.room

import android.content.Context
import androidx.room.Room
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.utilities.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object HitDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext
        context: Context
    ) = Room
        .databaseBuilder(
            context,
            HitsDatabase::class.java,
            DATABASE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideDao(db: HitsDatabase) = db.dao

}