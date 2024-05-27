package com.fiap.smartCity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.smartCity.models.Caminhao;
import com.fiap.smartCity.models.PontoColeta;
import com.fiap.smartCity.models.Rota;
import com.fiap.smartCity.repositories.CaminhaoRepository;
import com.fiap.smartCity.repositories.PontoColetaRepository;
import com.fiap.smartCity.repositories.RotaRepository;

@Service
public class RotaService {

    private final RotaRepository rotaRepository;
    private final CaminhaoRepository caminhaoRepository;
    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    public RotaService(RotaRepository rotaRepository, CaminhaoRepository caminhaoRepository) {
        this.rotaRepository = rotaRepository;
        this.caminhaoRepository = caminhaoRepository;
    }

    public List<Rota> getAllRotas() {
        return rotaRepository.findAll();
    }

    public Rota saveRota(Rota rota) {
        List<PontoColeta> pontosColeta = new ArrayList<>();
    
        for (PontoColeta pontoColeta : rota.getPontosColeta()) {
            // Buscar o ponto de coleta do banco de dados
            PontoColeta pontoColetaExistente = pontoColetaRepository.findById(pontoColeta.getId())
                .orElseThrow();
    
            // Definir a rota para o ponto de coleta existente
            pontoColetaExistente.setRota(rota);
    
            pontosColeta.add(pontoColetaExistente);
        }
    
        // Associar a lista de pontos de coleta à rota
        rota.setPontosColeta(pontosColeta);
    
        return rotaRepository.save(rota);
    }

    public void deleteRota(Long id) {
        if (!rotaRepository.existsById(id)) {
            throw new IllegalArgumentException("Rota com id " + id + " não encontrada");
        }
        rotaRepository.deleteById(id);
    }

    public Rota editRota(Rota rota, Long id) {
        Rota rotaExistente = rotaRepository.findById(id).orElse(null);
        if (rotaExistente == null) {
            throw new IllegalArgumentException("Rota com id " + id + " não encontrada");
        }
    
        rotaExistente.setPontoPartida(rota.getPontoPartida());
    
        return rotaRepository.save(rotaExistente);
    }



}
