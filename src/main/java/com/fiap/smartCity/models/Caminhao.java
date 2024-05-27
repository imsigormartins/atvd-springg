package com.fiap.smartCity.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Caminhao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cor;
    private String placa;
    private String modelo;
    private String marca;
    private String ano;
    private String capacidade;

    // @OneToMany(mappedBy = "caminhao", fetch = FetchType.LAZY)
    // private List<Rota> rota;

    public Caminhao() {

    }

    public Caminhao(String cor, String placa, String modelo, String marca, String ano, String capacidade) {
        this.cor = cor;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.capacidade = capacidade;
    }
}
