package com.sislocacao.core.repository;

import com.sislocacao.core.domain.model.Usuario;

import java.util.Optional;

public interface IUsuarioRepository {
    Usuario salvarUsuario(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
}
