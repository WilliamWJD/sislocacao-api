package com.sislocacao.adapter.output.mapper;

import com.sislocacao.core.domain.model.Usuario;
import com.sislocacao.adapter.output.repository.jpa.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {
    UsuarioEntity paraUsuarioEntity(Usuario usuario);
    Usuario paraUsuario(UsuarioEntity usuarioEntity);
}
