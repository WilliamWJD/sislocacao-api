package com.sislocacao.core.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Imovel {
    private Long id;

    private String descricao;
    private Boolean garagem;
    private Integer comodos;

    private List<Locacao> locacoes = new ArrayList<>();
    private Endereco endereco;

    public Imovel(Long id, String descricao, Boolean garagem, Integer comodos, List<Locacao> locacoes, Endereco endereco) {
        this.id = id;
        this.descricao = descricao;
        this.garagem = garagem;
        this.comodos = comodos;
        this.locacoes = locacoes;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getGaragem() {
        return garagem;
    }

    public Integer getComodos() {
        return comodos;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
