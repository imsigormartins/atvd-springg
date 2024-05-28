package com.fiap.smartCity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.smartCity.DTOs.AgendamentoDTO;
import com.fiap.smartCity.models.Agendamento;
import com.fiap.smartCity.services.AgendamentoService;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {
        @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public List<Agendamento> getAllAgendamentos() {
        return agendamentoService.getAllAgendamentos();
    }

    // @PostMapping
    // public Agendamento saveAgendamento(@RequestBody Agendamento agendamento) {
    //     return agendamentoService.saveAgendamento(agendamento);
    // }

    @PostMapping
    public AgendamentoDTO saveAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {
        Agendamento agendamento = agendamentoService.convertDtoToEntity(agendamentoDTO);
        Agendamento savedAgendamento = agendamentoService.saveAgendamento(agendamento);
        return agendamentoService.convertEntityToDto(savedAgendamento);
    }

    @PutMapping("/{id}")
    public AgendamentoDTO editAgendamento(@RequestBody AgendamentoDTO agendamentoDTO, @PathVariable Long id) {
        Agendamento agendamento = agendamentoService.convertDtoToEntity(agendamentoDTO);
        Agendamento updatedAgendamento = agendamentoService.editAgendamento(agendamento, id);
        return agendamentoService.convertEntityToDto(updatedAgendamento);
    }

    @DeleteMapping("/{id}")
    public void deleteAgendamento(Long id) {
        agendamentoService.deleteAgendamento(id);
    }
}
