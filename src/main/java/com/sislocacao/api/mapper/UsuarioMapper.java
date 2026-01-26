package com.sislocacao.api.mapper;

import com.sislocacao.api.request.SalvarUsuarioRequest;
import com.sislocacao.api.response.UsuarioResponse;
import com.sislocacao.domain.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario paraUsuario(SalvarUsuarioRequest salvarUsuarioRequest);
    UsuarioResponse paraUsuarioResponse(Usuario usuario);
}
