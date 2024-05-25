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
        caminhaoRepository.deleteById(id);
	}

    public Caminhao editCaminhao(Caminhao caminhao, Long id) {
        if (!caminhaoRepository.existsById(id)) {
            throw new RuntimeException("Caminhao não encontrado");
        } else {
            Caminhao caminhaoToUpdate = caminhaoRepository.findById(id).get();
            caminhaoToUpdate.setCor(caminhao.getCor());
            caminhaoToUpdate.setPlaca(caminhao.getPlaca());
            caminhaoToUpdate.setMarca(caminhao.getMarca());
            caminhaoToUpdate.setModelo(caminhao.getModelo());
            caminhaoToUpdate.setAno(caminhao.getAno());
            caminhaoToUpdate.setCapacidade(caminhao.getCapacidade());
            return caminhaoRepository.save(caminhaoToUpdate);
        }
    }
    
}
