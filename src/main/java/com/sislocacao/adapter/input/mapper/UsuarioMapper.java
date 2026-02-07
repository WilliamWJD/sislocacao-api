package com.sislocacao.adapter.input.mapper;

import com.sislocacao.adapter.input.dto.request.SalvarUsuarioRequest;
import com.sislocacao.adapter.input.dto.response.UsuarioResponse;
import com.sislocacao.core.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario paraUsuario(SalvarUsuarioRequest salvarUsuarioRequest);
    UsuarioResponse paraUsuarioResponse(Usuario usuario);
}
