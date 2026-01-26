package com.sislocacao.domain.entity;

public class Usuario {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Boolean ativo;

    public Usuario(Long id, String nome, String sobrenome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.ativo = Boolean.TRUE;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
