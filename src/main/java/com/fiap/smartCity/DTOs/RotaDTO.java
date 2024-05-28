package com.fiap.smartCity.DTOs;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RotaDTO {
    private Long id;
    private String pontoPartida;
    private List<Long> pontosColetaIds = new ArrayList<>();
    private Long caminhaoId;
}
