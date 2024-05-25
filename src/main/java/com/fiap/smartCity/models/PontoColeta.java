package com.fiap.smartCity.models;

import java.util.List;

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
    private Rota rota;

    @OneToMany(mappedBy = "pontoColeta")
    private List<Agendamento> agendamentos;

    // toString, equals, hashCode

    @Override
    public String toString() {
        return "PontoColeta [endereco=" + endereco + ", id=" + id + ", observacao=" + observacao + ", quantidade="
                + quantidade + ", tipoResiduo=" + tipoResiduo + "]";
    }

}
