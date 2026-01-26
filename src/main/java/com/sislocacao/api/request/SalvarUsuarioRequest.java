package com.sislocacao.api.request;

public record SalvarUsuarioRequest(
    String nome,
    String sobrenome,
    String email,
    String senha
) { }
