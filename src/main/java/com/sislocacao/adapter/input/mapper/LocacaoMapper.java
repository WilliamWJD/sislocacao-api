package com.sislocacao.adapter.input.mapper;

import com.sislocacao.adapter.input.dto.request.SalvarLocacaoRequest;
import com.sislocacao.adapter.input.dto.response.LocacaoResponse;
import com.sislocacao.core.domain.model.Locacao;
import com.sislocacao.core.usecase.locacao.SalvarLocacaoCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocacaoMapper {
    SalvarLocacaoCommand paraSalvarLocacaoCommand(SalvarLocacaoRequest request);
    LocacaoResponse paraLocacaoResponse(Locacao command);
}
