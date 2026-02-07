package com.sislocacao.adapter.output.repository.impl;

import com.sislocacao.adapter.output.mapper.UsuarioEntityMapper;
import com.sislocacao.adapter.output.repository.jpa.UsuarioJpaRepository;
import com.sislocacao.core.domain.model.Usuario;
import com.sislocacao.core.repository.IUsuarioRepository;
import com.sislocacao.adapter.output.repository.jpa.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioRepositoryAdapter implements IUsuarioRepository {

    private UsuarioJpaRepository usuarioJpaRepository;
    private UsuarioEntityMapper usuarioEntityMapper;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository, UsuarioEntityMapper usuarioEntityMapper) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.usuarioEntityMapper = usuarioEntityMapper;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioEntityMapper.paraUsuarioEntity(usuario);
        return usuarioEntityMapper.paraUsuario(usuarioJpaRepository.save(usuarioEntity));
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        Optional<UsuarioEntity> usuarioEntity = usuarioJpaRepository.findByEmail(email);
        return usuarioEntity.map(usuarioEntityMapper::paraUsuario);
    }
}
