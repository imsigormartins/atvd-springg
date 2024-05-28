package com.fiap.smartCity.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaminhaoDTO {
    private Long id;
    private String cor;
    private String placa;
    private String modelo;
    private String marca;
    private String ano;
    private String capacidade;
    // getters and setters
}