package com.sislocacao.adapter.output.mapper;

import com.sislocacao.adapter.output.repository.jpa.entity.ImovelEntity;
import com.sislocacao.core.domain.model.Imovel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImovelAdapterMapper {

    @Mapping(target = "locacoes", ignore = true)
    Imovel paraImovel(ImovelEntity Imovel);
}
