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

import com.fiap.smartCity.DTOs.CaminhaoDTO;
import com.fiap.smartCity.models.Caminhao;
import com.fiap.smartCity.services.CaminhaoService;
@RestController
@RequestMapping("/api/caminhoes")
public class CaminhaoController {
    @Autowired
    private CaminhaoService caminhaoService;

    @GetMapping
    public List<CaminhaoDTO> getAllCaminhoes() {
        return caminhaoService.getAllCaminhoes().stream()
            .map(caminhaoService::convertEntityToDto)
            .collect(Collectors.toList());
    }

    @PostMapping
    public CaminhaoDTO createCaminhao(@RequestBody CaminhaoDTO caminhaoDTO) {
        Caminhao caminhao = caminhaoService.convertDtoToEntity(caminhaoDTO);
        Caminhao savedCaminhao = caminhaoService.saveCaminhao(caminhao);
        return caminhaoService.convertEntityToDto(savedCaminhao);
    }

    @PutMapping({"/{id}"})
    public CaminhaoDTO updateCaminhao(@RequestBody CaminhaoDTO caminhaoDTO, @PathVariable Long id) {
        Caminhao caminhao = caminhaoService.editCaminhao(caminhaoService.convertDtoToEntity(caminhaoDTO), id);
        return caminhaoService.convertEntityToDto(caminhao);
    }

    @DeleteMapping({"/{id}"})
    public void deleteCaminhao(@PathVariable Long id) {
        caminhaoService.deleteCaminhao(id);
    }



}