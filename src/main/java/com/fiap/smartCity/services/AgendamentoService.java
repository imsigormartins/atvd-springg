package com.fiap.smartCity.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.smartCity.models.Agendamento;
import com.fiap.smartCity.models.PontoColeta;
import com.fiap.smartCity.repositories.AgendamentoRepository;

import jakarta.persistence.ManyToOne;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento saveAgendamento(Agendamento agendamento) {

        return agendamentoRepository.save(agendamento);
    }

    public Agendamento editAgendamento(Agendamento agendamento, Long id) {
        Agendamento agendamentoExistente = agendamentoRepository.findById(id).orElse(null);
        if (agendamentoExistente == null) {
            throw new IllegalArgumentException("Agendamento com id " + id + " não encontrado");
        }

        agendamentoExistente.setData(agendamento.getData());
        agendamentoExistente.setHora(agendamento.getHora());
        agendamentoExistente.setEndereco(agendamento.getEndereco());
        agendamentoExistente.setTipoResiduo(agendamento.getTipoResiduo());
        agendamentoExistente.setQuantidade(agendamento.getQuantidade());
        agendamentoExistente.setObservacao(agendamento.getObservacao());

        return agendamentoRepository.save(agendamentoExistente);
    }

    public void deleteAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }
    
}
