package com.sislocacao.adapter.output.mapper;

import com.sislocacao.adapter.output.repository.jpa.entity.LocacaoEntity;
import com.sislocacao.core.domain.model.Locacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocacaoAdapterMapper {

    LocacaoEntity paraLocacaoEntity(Locacao Locacao);

    @Mapping(target = "inquilino.locacoesEntity", ignore = true)
    @Mapping(target = "imovel.locacoes", ignore = true)
    Locacao paraLocacao(LocacaoEntity LocacaoEntity);
}
