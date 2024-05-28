package com.fiap.smartCity.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.smartCity.DTOs.AgendamentoDTO;
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
        if (!agendamentoRepository.existsById(id)) {
            throw new IllegalArgumentException("Agendamento com id " + id + " não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }

    public Agendamento convertDtoToEntity(AgendamentoDTO agendamentoDTO) {
        Agendamento agendamento = new Agendamento();
        agendamento.setData(agendamentoDTO.getData());
        agendamento.setHora(agendamentoDTO.getHora());
        agendamento.setEndereco(agendamentoDTO.getEndereco());
        agendamento.setTipoResiduo(agendamentoDTO.getTipoResiduo());
        agendamento.setQuantidade(agendamentoDTO.getQuantidade());
        agendamento.setObservacao(agendamentoDTO.getObservacao());
        // set other fields as needed
        return agendamento;
    }

    public AgendamentoDTO convertEntityToDto(Agendamento savedAgendamento) {
        AgendamentoDTO agendamentoDTO = new AgendamentoDTO();
        agendamentoDTO.setData(savedAgendamento.getData());
        agendamentoDTO.setHora(savedAgendamento.getHora());
        agendamentoDTO.setEndereco(savedAgendamento.getEndereco());
        agendamentoDTO.setTipoResiduo(savedAgendamento.getTipoResiduo());
        agendamentoDTO.setQuantidade(savedAgendamento.getQuantidade());
        agendamentoDTO.setObservacao(savedAgendamento.getObservacao());
        // set other fields as needed
        return agendamentoDTO;
    }
}
