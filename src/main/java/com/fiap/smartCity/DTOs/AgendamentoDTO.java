package com.fiap.smartCity.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoDTO {
    private String data;
    private String hora;
    private String endereco;
    private String tipoResiduo;
    private String quantidade;
    private String observacao;
}
