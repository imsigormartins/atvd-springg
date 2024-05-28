package com.fiap.smartCity.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
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
public class PontoColeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String endereco;
    private String tipoResiduo;
    private String quantidade;
    private String observacao;

    @ManyToOne
    @JsonBackReference
    private Rota rota;

    @OneToMany(mappedBy = "pontoColeta")
    @JsonManagedReference
    private List<Agendamento> agendamentos;

}
