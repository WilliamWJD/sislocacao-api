package com.sislocacao.api.controllers;

import com.sislocacao.api.mapper.UsuarioMapper;
import com.sislocacao.api.request.SalvarUsuarioRequest;
import com.sislocacao.api.response.UsuarioResponse;
import com.sislocacao.application.usecase.usuario.SalvarUsuarioUseCase;
import com.sislocacao.domain.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final SalvarUsuarioUseCase salvarUsuarioUseCase;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(SalvarUsuarioUseCase salvarUsuarioUseCase, UsuarioMapper usuarioMapper) {
        this.salvarUsuarioUseCase = salvarUsuarioUseCase;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<Object> salvarUsuario(@RequestBody SalvarUsuarioRequest salvarUsuarioRequest){
        Usuario usuario = usuarioMapper.paraUsuario(salvarUsuarioRequest);
        UsuarioResponse usuarioResponse = usuarioMapper.paraUsuarioResponse(salvarUsuarioUseCase.executar(usuario));
        return ResponseEntity.ok(usuarioResponse);
    }
}
