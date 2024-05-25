package com.fiap.smartCity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.smartCity.models.Caminhao;
import com.fiap.smartCity.models.PontoColeta;
import com.fiap.smartCity.models.Rota;
import com.fiap.smartCity.repositories.CaminhaoRepository;
import com.fiap.smartCity.repositories.RotaRepository;

@Service
public class RotaService {

    private final RotaRepository rotaRepository;
    private final CaminhaoRepository caminhaoRepository;

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
            PontoColeta novoPontoColeta = new PontoColeta();
            novoPontoColeta.setEndereco(pontoColeta.getEndereco());
            novoPontoColeta.setQuantidade(pontoColeta.getQuantidade());
            novoPontoColeta.setTipoResiduo(pontoColeta.getTipoResiduo());
            novoPontoColeta.setObservacao(pontoColeta.getObservacao());
            novoPontoColeta.setRota(rota);
            pontosColeta.add(novoPontoColeta);
        }

        // associar a lista de pontos de coleta à rota
        rota.setPontosColeta(pontosColeta);

        return rotaRepository.save(rota);
    }

    public void deleteRota(Long id) {
        rotaRepository.deleteById(id);
    }

    public Rota editRota(Rota rota, Long id) {
        Rota rotaExistente = rotaRepository.findById(id).orElse(null);
        if (rotaExistente == null) {
            throw new IllegalArgumentException("Rota com id " + id + " não encontrada");
        }
        rotaExistente.setPontoPartida(rota.getPontoPartida());

        // instanciar a lista de pontos de coleta
        List<PontoColeta> pontosColeta = new ArrayList<>();

        for (PontoColeta pontoColeta : rota.getPontosColeta()) {
            PontoColeta novoPontoColeta = new PontoColeta();
            novoPontoColeta.setEndereco(pontoColeta.getEndereco());
            novoPontoColeta.setQuantidade(pontoColeta.getQuantidade());
            novoPontoColeta.setTipoResiduo(pontoColeta.getTipoResiduo());
            novoPontoColeta.setObservacao(pontoColeta.getObservacao());
            novoPontoColeta.setRota(rotaExistente);
            pontosColeta.add(novoPontoColeta);
        }

        // associar a lista de pontos de coleta à rota
        rotaExistente.setPontosColeta(pontosColeta);

        return rotaRepository.save(rotaExistente);
    }



}
