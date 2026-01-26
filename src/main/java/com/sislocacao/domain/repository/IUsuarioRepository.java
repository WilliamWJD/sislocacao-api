package com.sislocacao.domain.repository;

import com.sislocacao.domain.entity.Usuario;

import java.util.Optional;

public interface IUsuarioRepository {
    Usuario salvarUsuario(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
}
