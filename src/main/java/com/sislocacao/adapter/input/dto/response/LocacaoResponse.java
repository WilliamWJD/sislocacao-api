package com.sislocacao.adapter.input.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LocacaoResponse(
        Long id,
        LocalDate dataDeInicio,
        LocalDate dataDeTermino,
        BigDecimal valorAluguel,
        InquilinoResponse inquilino,
        ImovelResponse imovel,
        LocadorResponse locador
) { }
