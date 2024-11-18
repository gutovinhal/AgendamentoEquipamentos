package com.example.agendamentoequipamentos.agendamento.di

import android.content.Context
import androidx.room.Room
import com.example.agendamentoequipamentos.agendamento.data.dao.AgendamentoDao
import com.example.agendamentoequipamentos.agendamento.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "agendamento_db"
        ).build()
    }

    @Provides
    fun provideAgendamentoDao(database: AppDatabase): AgendamentoDao {
        return database.agendamentoDao()
    }
}
