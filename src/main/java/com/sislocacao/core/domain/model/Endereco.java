package com.sislocacao.core.domain.model;

public class Endereco {
    private String logradouro;
    private String estado;
    private String bairro;
    private String cidade;
    private String cep;

    public Endereco(String logradouro, String estado, String bairro, String cidade, String cep) {
        this.logradouro = logradouro;
        this.estado = estado;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public Endereco criarEndereco(String logradouro, String estado, String bairro, String cidade, String cep) {
        return new Endereco(logradouro, estado, bairro, cidade, cep);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }
}
