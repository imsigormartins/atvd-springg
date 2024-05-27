package com.fiap.smartCity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.smartCity.models.PontoColeta;
import com.fiap.smartCity.services.PontoColetaService;

@RestController
@RequestMapping("/api/pontos-coleta")
public class PontoColetaController {
        @Autowired
    private PontoColetaService pontoColetaService;

    @GetMapping
    public List<PontoColeta> getAllPontosColeta() {
        return pontoColetaService.getAllPontosColeta();
    }

    @PostMapping
    public PontoColeta savePontoColeta(@RequestBody PontoColeta pontoColeta) {
        return pontoColetaService.savePontoColeta(pontoColeta);
    }

    @PutMapping("/{id}")
    public PontoColeta editPontoColeta(@RequestBody PontoColeta pontoColeta, Long id) {
        return pontoColetaService.editPontoColeta(pontoColeta, id);
    }

    @DeleteMapping("/{id}")
    public void deletePontoColeta(Long id) {
        pontoColetaService.deletePontoColeta(id);
    }
}
