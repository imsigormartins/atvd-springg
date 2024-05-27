package com.fiap.smartCity.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.smartCity.models.Notificacao;
import com.fiap.smartCity.repositories.NotificacaoRepository;

@Service
public class NotificacaoService {
    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public List<Notificacao> getAllNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Notificacao saveNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao editNotificacao(Notificacao notificacao, Long id) {
        Notificacao notificacaoExistente = notificacaoRepository.findById(id).orElse(null);
        if (notificacaoExistente == null) {
            throw new IllegalArgumentException("Notificacao com id " + id + " não encontrado");
        }
    
        notificacaoExistente.setMensagem(notificacao.getMensagem());
    
        return notificacaoRepository.save(notificacaoExistente);
    }

    public void deleteNotificacao(Long id) {
        if (!notificacaoRepository.existsById(id)) {
            throw new IllegalArgumentException("Notificacao com id " + id + " não encontrado");
        }
        notificacaoRepository.deleteById(id);
    }
}
