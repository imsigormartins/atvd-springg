package com.fiap.smartCity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.smartCity.models.PontoColeta;
import com.fiap.smartCity.repositories.PontoColetaRepository;



@Service
public class PontoColetaService {

    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    public List<PontoColeta> getAllPontosColeta() {
        return pontoColetaRepository.findAll();
    }

    public PontoColeta savePontoColeta(PontoColeta pontoColeta) {
        System.out.println(pontoColeta.toString());
        return pontoColetaRepository.save(pontoColeta);
    }

    public PontoColeta editPontoColeta(PontoColeta pontoColeta, Long id) {
        PontoColeta pontoColetaExistente = pontoColetaRepository.findById(id).orElse(null);
        if (pontoColetaExistente == null) {
            throw new IllegalArgumentException("PontoColeta com id " + id + " não encontrado");
        }

        pontoColetaExistente.setEndereco(pontoColeta.getEndereco());
        pontoColetaExistente.setTipoResiduo(pontoColeta.getTipoResiduo());
        pontoColetaExistente.setQuantidade(pontoColeta.getQuantidade());
        pontoColetaExistente.setObservacao(pontoColeta.getObservacao());
        pontoColetaExistente.setRota(pontoColeta.getRota());
        pontoColetaExistente.setAgendamentos(pontoColeta.getAgendamentos());
        
        return pontoColetaRepository.save(pontoColetaExistente);
    }

    public void deletePontoColeta(Long id) {
        pontoColetaRepository.deleteById(id);
    }

}
