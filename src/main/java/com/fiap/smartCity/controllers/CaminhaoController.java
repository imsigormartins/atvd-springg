package com.fiap.smartCity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.smartCity.models.Caminhao;
import com.fiap.smartCity.services.CaminhaoService;

@RestController
@RequestMapping("/api/caminhoes")
public class CaminhaoController {
    @Autowired
    private CaminhaoService caminhaoService;

    @GetMapping
    public List<Caminhao> getAllCaminhoes() {
        return caminhaoService.getAllCaminhoes();
    }

    @PostMapping
    public Caminhao createCaminhao(@RequestBody Caminhao caminhao) {
        return caminhaoService.saveCaminhao(caminhao);
    }

    @PutMapping({"/{id}"})
    public Caminhao updateCaminhao(@RequestBody Caminhao caminhao, @PathVariable Long id) {
        return caminhaoService.editCaminhao(caminhao,id);
    }


    @DeleteMapping({"/{id}"})
    public void deleteCaminhao(@PathVariable Long id) {
        caminhaoService.deleteCaminhao(id);
    }
}
