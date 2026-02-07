package com.sislocacao.adapter.output.mapper;

import com.sislocacao.adapter.output.repository.jpa.entity.LocacaoEntity;
import com.sislocacao.core.domain.model.Locacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocacaoAdapterMapper {

    LocacaoEntity paraLocacaoEntity(Locacao Locacao);
    Locacao paraLocacao(LocacaoEntity LocacaoEntity);
}
