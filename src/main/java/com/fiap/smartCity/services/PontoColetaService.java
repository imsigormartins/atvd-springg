package com.fiap.smartCity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.smartCity.models.PontoColeta;
import com.fiap.smartCity.models.Rota;
import com.fiap.smartCity.repositories.PontoColetaRepository;
import com.fiap.smartCity.repositories.RotaRepository;

@Service
public class PontoColetaService {

    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    @Autowired
    private RotaRepository rotaRepository;

    public List<PontoColeta> getAllPontosColeta() {
        return pontoColetaRepository.findAll();
    }

    public PontoColeta savePontoColeta(PontoColeta pontoColeta) {
        
        Rota rota = rotaRepository.findById(pontoColeta.getRota().getId()).orElse(null);

        if (rota == null) {
            throw new IllegalArgumentException("Rota com id " + pontoColeta.getRota().getId() + " não encontrada");
        }

        pontoColeta.setRota(rota);

        return pontoColetaRepository.save(pontoColeta);
    }

    public PontoColeta editPontoColeta(PontoColeta pontoColeta, Long id) {
        PontoColeta pontoColetaExistente = pontoColetaRepository.findById(id).orElse(null);

        return pontoColetaRepository.save(pontoColetaExistente);
    }

    public void deletePontoColeta(Long id) {
        pontoColetaRepository.deleteById(id);
    }

}
