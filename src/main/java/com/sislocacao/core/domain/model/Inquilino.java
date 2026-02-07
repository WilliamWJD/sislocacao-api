package com.sislocacao.core.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inquilino {
    private Long id;

    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private String nacionalidade;
    private String estadoCivil;
    private String profissao;
    private String genero;
    private LocalDate dataNascimento;

    private List<Locacao> locacoesEntity = new ArrayList<>();

    public Inquilino(Long id, String nome, String sobrenome, String cpf, String rg, String telefone, String email, String nacionalidade, String estadoCivil, String profissao, String genero, LocalDate dataNascimento, List<Locacao> locacoesEntity) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.nacionalidade = nacionalidade;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.locacoesEntity = locacoesEntity;
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

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<Locacao> getLocacoesEntity() {
        return locacoesEntity;
    }
}
