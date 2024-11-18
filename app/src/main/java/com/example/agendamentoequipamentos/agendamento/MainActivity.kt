package com.example.agendamentoequipamentos.agendamento

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.agendamentoequipamentos.R
import com.example.agendamentoequipamentos.agendamento.data.model.Agendamento
import com.example.agendamentoequipamentos.agendamento.viewmodel.AgendamentoViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: AgendamentoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val equipmentName = findViewById<EditText>(R.id.equipmentName)
        val bookingDate = findViewById<EditText>(R.id.bookingDate)
        val responsiblePerson = findViewById<EditText>(R.id.responsiblePerson)
        val designatedWork = findViewById<EditText>(R.id.designatedWork)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = equipmentName.text.toString()
            val date = bookingDate.text.toString()
            val person = responsiblePerson.text.toString()
            val work = designatedWork.text.toString()

            if (name.isNotEmpty() && date.isNotEmpty() && person.isNotEmpty() && work.isNotEmpty()) {
                val agendamento = Agendamento(0, name, date, person, work)
                viewModel.inserir(agendamento)
                Toast.makeText(this, "Equipamento agendado com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}