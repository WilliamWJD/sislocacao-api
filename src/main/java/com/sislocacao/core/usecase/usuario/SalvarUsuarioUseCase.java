package com.sislocacao.core.usecase.usuario;

import com.sislocacao.core.common.DomainComponent;
import com.sislocacao.core.domain.model.Usuario;
import com.sislocacao.core.exception.BusinessException;
import com.sislocacao.core.repository.IUsuarioRepository;
import com.sislocacao.ports.input.SalvarUsuarioInputPort;

import java.util.Optional;

@DomainComponent
public class SalvarUsuarioUseCase implements SalvarUsuarioInputPort {

    private final IUsuarioRepository usuarioRepository;

    public SalvarUsuarioUseCase(IUsuarioRepository repository) {
        this.usuarioRepository = repository;
    }

    @Override
    public Usuario executar(Usuario usuario) {
        Optional<Usuario> checkUsuarioExistente = usuarioRepository.buscarPorEmail(usuario.getEmail());

        if(checkUsuarioExistente.isPresent()) {
            throw new BusinessException("Já existe um usuário cadastrado com o e-mail informado.");
        }

        Usuario usuarioCriado = new Usuario(
                null,
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getEmail(),
                usuario.getSenha()
        );

        return usuarioRepository.salvarUsuario(usuarioCriado);
    }
}
