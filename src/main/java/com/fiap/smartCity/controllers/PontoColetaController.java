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

import com.fiap.smartCity.DTOs.PontoColetaDTO;
import com.fiap.smartCity.models.PontoColeta;
import com.fiap.smartCity.services.PontoColetaService;

@RestController
@RequestMapping("/api/pontos-coleta")
public class PontoColetaController {
    @Autowired
    private PontoColetaService pontoColetaService;

    @GetMapping
    public List<PontoColetaDTO> getAllPontosColeta() {
        return pontoColetaService.getAllPontosColeta().stream()
            .map(pontoColetaService::convertEntityToDto)
            .collect(Collectors.toList());
    }

    @PostMapping
    public PontoColetaDTO savePontoColeta(@RequestBody PontoColetaDTO pontoColetaDTO) {
        PontoColeta pontoColeta = pontoColetaService.convertDtoToEntity(pontoColetaDTO);
        PontoColeta pontoColetaSaved = pontoColetaService.savePontoColeta(pontoColeta);
        return pontoColetaService.convertEntityToDto(pontoColetaSaved);
    }

    @PutMapping("/{id}")
    public PontoColetaDTO editPontoColeta(@RequestBody PontoColetaDTO pontoColetaDTO, @PathVariable Long id) {
        PontoColeta pontoColeta = pontoColetaService.convertDtoToEntity(pontoColetaDTO);
        PontoColeta pontoColetaEdited = pontoColetaService.editPontoColeta(pontoColeta, id);
        return pontoColetaService.convertEntityToDto(pontoColetaEdited);
    }

    @DeleteMapping("/{id}")
    public void deletePontoColeta(@PathVariable Long id) {
        pontoColetaService.deletePontoColeta(id);
    }

}
