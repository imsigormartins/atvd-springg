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

import com.fiap.smartCity.DTOs.RotaDTO;
import com.fiap.smartCity.models.PontoColeta;
import com.fiap.smartCity.models.Rota;
import com.fiap.smartCity.services.RotaService;
@RestController
@RequestMapping("/api/rotas")
public class RotaController {
    @Autowired
    private RotaService rotaService;

    @GetMapping
    public List<RotaDTO> getAllRotas() {
        return rotaService.getAllRotas().stream()
            .map(rotaService::convertEntityToDto)
            .collect(Collectors.toList());
    }

    @PostMapping
    public RotaDTO createRota(@RequestBody RotaDTO rotaDTO) {
        Rota rota = rotaService.saveRota(rotaService.convertDtoToEntity(rotaDTO));
        Rota rotaSaved = rotaService.saveRota(rota);
        return rotaService.convertEntityToDto(rotaSaved);
    }

    @PutMapping("/{id}")
    public RotaDTO updateRota(@RequestBody RotaDTO rotaDTO, @PathVariable Long id) {
        Rota rota = rotaService.editRota(rotaService.convertDtoToEntity(rotaDTO), id);
        Rota rotaEdited = rotaService.editRota(rota, id);
        return rotaService.convertEntityToDto(rotaEdited);
    }

    @DeleteMapping("/{id}")
    public void deleteRota(@PathVariable Long id) {
        rotaService.deleteRota(id);
    }


}
