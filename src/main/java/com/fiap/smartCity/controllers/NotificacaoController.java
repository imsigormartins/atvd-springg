package com.fiap.smartCity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.smartCity.models.Notificacao;
import com.fiap.smartCity.services.NotificacaoService;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {
        @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public List<Notificacao> getAllNotificacoes() {
        return notificacaoService.getAllNotificacoes();
    }

    @PostMapping
    public Notificacao saveNotificacao(@RequestBody Notificacao notificacao) {
        return notificacaoService.saveNotificacao(notificacao);
    }

    @PutMapping("/{id}")
    public Notificacao editNotificacao(@RequestBody Notificacao notificacao, Long id) {
        return notificacaoService.editNotificacao(notificacao, id);
    }

    @DeleteMapping("/{id}")
    public void deleteNotificacao(Long id) {
        notificacaoService.deleteNotificacao(id);
    }
}
