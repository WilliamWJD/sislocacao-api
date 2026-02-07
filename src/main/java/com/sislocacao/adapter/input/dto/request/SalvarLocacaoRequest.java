package com.sislocacao.adapter.input.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SalvarLocacaoRequest(
        LocalDate dataDeInicio,
        Integer tempoDeContrato,
        BigDecimal valorAluguel,
        Long idInquilino,
        Long idImovel,
        Long idLocador
) { }
