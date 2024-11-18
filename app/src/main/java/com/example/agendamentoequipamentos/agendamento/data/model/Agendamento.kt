package com.example.agendamentoequipamentos.agendamento.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "agendamentos")
data class Agendamento(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nomeEquipamento: String,
    val dataAgendamento: String,
    val encarregadoResponsavel: String,
    val obraDesignada: String
)
