package com.sislocacao.infrastructure.persistence.repository.adapters;

import com.sislocacao.domain.entity.Usuario;
import com.sislocacao.domain.repository.IUsuarioRepository;
import com.sislocacao.infrastructure.persistence.entity.UsuarioEntity;
import com.sislocacao.infrastructure.persistence.mapper.UsuarioEntityMapper;
import com.sislocacao.infrastructure.persistence.repository.jpa.UsuarioJpaRepository;
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
