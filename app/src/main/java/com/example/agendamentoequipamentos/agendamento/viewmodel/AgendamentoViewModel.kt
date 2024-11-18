package com.example.agendamentoequipamentos.agendamento.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.agendamentoequipamentos.agendamento.data.database.AppDatabase
import com.example.agendamentoequipamentos.agendamento.data.model.Agendamento
import com.example.agendamentoequipamentos.agendamento.data.repository.AgendamentoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgendamentoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: AgendamentoRepository

    private val _agendamentos = MutableLiveData<List<Agendamento>>()
    val agendamentos: LiveData<List<Agendamento>> get() = _agendamentos

    init {
        val agendamentoDao = AppDatabase.getDatabase(application).agendamentoDao()
        repository = AgendamentoRepository(agendamentoDao)
    }

    fun inserir(agendamento: Agendamento) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.inserir(agendamento)
        }
    }

    fun getAllAgendamentos() {    // Observe o LiveData do repositório e atualize o _agendamentos quando houver mudanças
        repository.getAll().observeForever { agendamentosList ->
            _agendamentos.postValue(agendamentosList)
        }
    }
}