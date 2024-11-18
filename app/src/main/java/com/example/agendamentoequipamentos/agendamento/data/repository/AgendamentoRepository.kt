package com.example.agendamentoequipamentos.agendamento.data.repository

import androidx.lifecycle.LiveData
import com.example.agendamentoequipamentos.agendamento.data.dao.AgendamentoDao
import com.example.agendamentoequipamentos.agendamento.data.model.Agendamento

class AgendamentoRepository(private val agendamentoDao: AgendamentoDao) {

    fun getAll(): LiveData<List<Agendamento>> {
        return agendamentoDao.getAll()
    }

    suspend fun inserir(agendamento: Agendamento) {
        agendamentoDao.inserir(agendamento)
    }
}
