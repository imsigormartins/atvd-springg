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

import com.fiap.smartCity.models.Rota;
import com.fiap.smartCity.services.RotaService;

@RestController
@RequestMapping("/api/rotas")
public class RotaController {
    @Autowired
    private RotaService rotaService;

    @GetMapping
    public List<Rota> getAllRotas() {
        return rotaService.getAllRotas();
    }

    @PostMapping
    public Rota createRota(@RequestBody Rota rota) {
        return rotaService.saveRota(rota);
    }

    @PutMapping({"/{id}"})
    public Rota updateRota(@RequestBody Rota rota, @PathVariable Long id) {
        return rotaService.editRota(rota, id);
    }

    @DeleteMapping({"/{id}"})
    public void deleteRota(@PathVariable Long id) {
        rotaService.deleteRota(id);
    }
}
