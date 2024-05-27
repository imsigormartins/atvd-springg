package com.fiap.smartCity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.smartCity.models.Caminhao;
import com.fiap.smartCity.repositories.CaminhaoRepository;

@Service
public class CaminhaoService {

    private final CaminhaoRepository caminhaoRepository;

    @Autowired
    public CaminhaoService(CaminhaoRepository caminhaoRepository) {
        this.caminhaoRepository = caminhaoRepository;
    }

    public List<Caminhao> getAllCaminhoes() {
        return caminhaoRepository.findAll();
    }

    public Caminhao saveCaminhao(Caminhao caminhao) {
        return caminhaoRepository.save(caminhao);
    }

    public void deleteCaminhao(Long id) {
        if (!caminhaoRepository.existsById(id)) {
            throw new IllegalArgumentException("Caminhao com id " + id + " não encontrado");
        }
        caminhaoRepository.deleteById(id);
    }

    public Caminhao editCaminhao(Caminhao caminhao, Long id) {
        Caminhao caminhaoExistente = caminhaoRepository.findById(id).orElse(null);
        if (caminhaoExistente == null) {
            throw new IllegalArgumentException("Caminhao com id " + id + " não encontrado");
        }
    
        caminhaoExistente.setCor(caminhao.getCor());
        caminhaoExistente.setPlaca(caminhao.getPlaca());
        caminhaoExistente.setMarca(caminhao.getMarca());
        caminhaoExistente.setModelo(caminhao.getModelo());
        caminhaoExistente.setAno(caminhao.getAno());
        caminhaoExistente.setCapacidade(caminhao.getCapacidade());
    
        return caminhaoRepository.save(caminhaoExistente);
    }
    
}
