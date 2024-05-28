package com.fiap.smartCity.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.smartCity.DTOs.NotificacaoDTO;
import com.fiap.smartCity.models.Notificacao;
import com.fiap.smartCity.services.NotificacaoService;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {
    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public List<NotificacaoDTO> getAllNotificacoes() {
        return notificacaoService.getAllNotificacoes().stream()
            .map(notificacaoService::convertEntityToDto)
            .collect(Collectors.toList());
    }

    @PostMapping
    public NotificacaoDTO saveNotificacao(@RequestBody NotificacaoDTO notificacaoDTO) {
        Notificacao notificacao = notificacaoService.convertDtoToEntity(notificacaoDTO);
        Notificacao notificacaoSaved = notificacaoService.saveNotificacao(notificacao);
        return notificacaoService.convertEntityToDto(notificacaoSaved);
    }

    @PutMapping("/{id}")
    public NotificacaoDTO editNotificacao(@RequestBody NotificacaoDTO notificacaoDTO, @PathVariable Long id) {
        Notificacao notificacao = notificacaoService.convertDtoToEntity(notificacaoDTO);
        Notificacao notificacaoEdited = notificacaoService.editNotificacao(notificacao, id);
        return notificacaoService.convertEntityToDto(notificacaoEdited);
    }

    @DeleteMapping("/{id}")
    public void deleteNotificacao(@PathVariable Long id) {
        notificacaoService.deleteNotificacao(id);
    }

}
