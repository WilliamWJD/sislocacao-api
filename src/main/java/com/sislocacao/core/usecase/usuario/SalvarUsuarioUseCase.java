package com.sislocacao.core.usecase.usuario;

import com.sislocacao.core.domain.model.Usuario;
import com.sislocacao.core.repository.IUsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalvarUsuarioUseCase {

    private final IUsuarioRepository usuarioRepository;

    public SalvarUsuarioUseCase(IUsuarioRepository repository) {
        this.usuarioRepository = repository;
    }

    public Usuario executar(Usuario usuario) {
        Optional<Usuario> checkUsuarioExistente = usuarioRepository.buscarPorEmail(usuario.getEmail());

        if(checkUsuarioExistente.isPresent()) {
            throw new IllegalArgumentException("Usuário com esse email já existe.");
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
