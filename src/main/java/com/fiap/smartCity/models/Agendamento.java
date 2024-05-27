package com.fiap.smartCity.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data;
    private String hora;
    private String endereco;
    private String tipoResiduo;
    private String quantidade;
    private String observacao;

    @ManyToOne
    @JsonBackReference
    private PontoColeta pontoColeta;
}
