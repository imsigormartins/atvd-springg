package com.fiap.smartCity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.smartCity.DTOs.PontoColetaDTO;
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
        if (pontoColeta.getRota() != null && pontoColeta.getRota().getId() != null) {
            Rota rota = rotaRepository.findById(pontoColeta.getRota().getId()).orElse(null);
    
            if (rota == null) {
                throw new IllegalArgumentException("Rota com id " + pontoColeta.getRota().getId() + " não encontrada");
            }
    
            pontoColeta.setRota(rota);
        }
    
        return pontoColetaRepository.save(pontoColeta);
    }

    public PontoColeta editPontoColeta(PontoColeta pontoColeta, Long id) {
        PontoColeta pontoColetaExistente = pontoColetaRepository.findById(id).orElse(null);
        if (pontoColetaExistente == null) {
            throw new IllegalArgumentException("PontoColeta com id " + id + " não encontrado");
        }
        pontoColetaExistente.setEndereco(pontoColeta.getEndereco());
        pontoColetaExistente.setQuantidade(pontoColeta.getQuantidade());
        pontoColetaExistente.setTipoResiduo(pontoColeta.getTipoResiduo());
        pontoColetaExistente.setObservacao(pontoColeta.getObservacao());
        return pontoColetaRepository.save(pontoColetaExistente);
    }

    public void deletePontoColeta(Long id) {
        if (!pontoColetaRepository.existsById(id)) {
            throw new IllegalArgumentException("PontoColeta com id " + id + " não encontrado");
        }
        pontoColetaRepository.deleteById(id);
    }

    public PontoColeta convertDtoToEntity(PontoColetaDTO pontoColetaDTO) {
        PontoColeta pontoColeta = new PontoColeta();
        pontoColeta.setId(pontoColetaDTO.getId());
        pontoColeta.setEndereco(pontoColetaDTO.getEndereco());
        pontoColeta.setTipoResiduo(pontoColetaDTO.getTipoResiduo());
        pontoColeta.setQuantidade(pontoColetaDTO.getQuantidade());
        pontoColeta.setObservacao(pontoColetaDTO.getObservacao());
        
        return pontoColeta;
    }

    public PontoColetaDTO convertEntityToDto(PontoColeta pontoColetaSaved) {
        PontoColetaDTO pontoColetaDTO = new PontoColetaDTO();
        pontoColetaDTO.setId(pontoColetaSaved.getId());
        pontoColetaDTO.setEndereco(pontoColetaSaved.getEndereco());
        pontoColetaDTO.setTipoResiduo(pontoColetaSaved.getTipoResiduo());
        pontoColetaDTO.setQuantidade(pontoColetaSaved.getQuantidade());
        pontoColetaDTO.setObservacao(pontoColetaSaved.getObservacao());
        if (pontoColetaSaved.getRota() != null) {
            pontoColetaDTO.setRotaId(pontoColetaSaved.getRota().getId());
        } else {
            pontoColetaDTO.setRotaId(null); // ou qualquer outro valor que faça sentido para seu contexto
        }
        
        return pontoColetaDTO;
    }

}
