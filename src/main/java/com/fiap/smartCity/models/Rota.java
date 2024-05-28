package com.fiap.smartCity.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pontoPartida;

    @OneToMany(mappedBy = "rota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PontoColeta> pontosColeta = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Caminhao caminhao;
}