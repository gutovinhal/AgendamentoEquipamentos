package com.example.agendamentoequipamentos.agendamento.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.agendamentoequipamentos.agendamento.data.model.Agendamento

@Dao
interface AgendamentoDao {
    @Insert
    suspend fun inserir(agendamento: Agendamento)

    @Query("SELECT * FROM agendamentos")
    fun getAll(): LiveData<List<Agendamento>>
}
