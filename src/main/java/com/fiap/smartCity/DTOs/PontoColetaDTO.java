package com.fiap.smartCity.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PontoColetaDTO {
    private Long id;
    private String endereco;
    private String tipoResiduo;
    private String quantidade;
    private String observacao;
    private Long rotaId;
}
