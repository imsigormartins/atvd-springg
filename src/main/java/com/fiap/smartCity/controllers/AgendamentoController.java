package com.fiap.smartCity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public Agendamento saveAgendamento(Agendamento agendamento) {
        return agendamentoService.saveAgendamento(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento editAgendamento(Agendamento agendamento, Long id) {
        return agendamentoService.editAgendamento(agendamento, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAgendamento(Long id) {
        agendamentoService.deleteAgendamento(id);
    }
}
