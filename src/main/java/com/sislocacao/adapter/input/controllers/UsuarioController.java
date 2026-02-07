package com.sislocacao.adapter.input.controllers;

import com.sislocacao.adapter.input.mapper.UsuarioMapper;
import com.sislocacao.adapter.input.dto.request.SalvarUsuarioRequest;
import com.sislocacao.adapter.input.dto.response.UsuarioResponse;
import com.sislocacao.core.usecase.usuario.SalvarUsuarioUseCase;
import com.sislocacao.core.domain.model.Usuario;
import com.sislocacao.ports.input.SalvarUsuarioInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final SalvarUsuarioInputPort salvarUsuarioInputPort;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(SalvarUsuarioInputPort salvarUsuarioInputPort, UsuarioMapper usuarioMapper) {
        this.salvarUsuarioInputPort = salvarUsuarioInputPort;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<Object> salvarUsuario(@RequestBody SalvarUsuarioRequest salvarUsuarioRequest){
        Usuario usuario = usuarioMapper.paraUsuario(salvarUsuarioRequest);
        UsuarioResponse usuarioResponse = usuarioMapper.paraUsuarioResponse(salvarUsuarioInputPort.executar(usuario));
        return ResponseEntity.ok(usuarioResponse);
    }
}
