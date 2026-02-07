package com.sislocacao.adapter.input.dto.request;

public record SalvarUsuarioRequest(
    String nome,
    String sobrenome,
    String email,
    String senha
) { }
