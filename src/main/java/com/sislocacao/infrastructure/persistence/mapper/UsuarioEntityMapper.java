package com.sislocacao.infrastructure.persistence.mapper;

import com.sislocacao.domain.entity.Usuario;
import com.sislocacao.infrastructure.persistence.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {
    UsuarioEntity paraUsuarioEntity(Usuario usuario);
    Usuario paraUsuario(UsuarioEntity usuarioEntity);
}
