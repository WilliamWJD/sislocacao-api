package com.sislocacao.core.domain.model;

import com.sislocacao.core.exception.BusinessException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Locacao {
    private Long id;

    private LocalDate dataDeInicio;
    private LocalDate dataDeTermino;
    private BigDecimal valorAluguel;

    private Inquilino inquilino;
    private Imovel imovel;
    private Locador locador;
    private Boolean status;

    public Locacao(Long id, LocalDate dataDeInicio, LocalDate dataDeTermino, BigDecimal valorAluguel, Inquilino inquilino, Imovel imovel, Locador locador) {
        this.id = id;
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
        this.valorAluguel = valorAluguel;
        this.inquilino = inquilino;
        this.imovel = imovel;
        this.locador = locador;

        validaLocacao();
        ativaLocacao();
    }

    public static Locacao criarLocacao(Long idLocacao, LocalDate dataDeInicio, Integer tempoDeContrato, BigDecimal valorAluguel, Inquilino inquilino, Imovel imovel, Locador locador) {
        return new Locacao(
                idLocacao,
                dataDeInicio,
                calculaDataDeTerminoComBaseNoTempoDeContrato(dataDeInicio, tempoDeContrato),
                valorAluguel,
                inquilino,
                imovel,
                locador
        );
    }

    public static LocalDate calculaDataDeTerminoComBaseNoTempoDeContrato(LocalDate dataDeInicio, Integer tempoDeContrato) {
        if(tempoDeContrato == 0) {
            throw new BusinessException("O Tempo de contrato deve ser maior que zero");
        }

        return dataDeInicio.plusMonths(tempoDeContrato);
    }

    public void ativaLocacao(){
        this.status = Boolean.TRUE;
    }

    public void desativaLocacao(){
        this.status = Boolean.FALSE;
    }

    public void validaLocacao(){
        if (dataDeInicio == null) {
            throw new BusinessException("Data de início é obrigatória");
        }

        if (valorAluguel == null || valorAluguel.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("O valor do aluguel deve ser maior que zero");
        }

        if (dataDeInicio.isAfter(dataDeTermino)) {
            throw new BusinessException("A data de início deve ser anterior à data de término");
        }

        if (inquilino == null || imovel == null || locador == null) {
            throw new BusinessException("Locação deve ter inquilino, imóvel e locador");
        }
    }

    public Locador getLocador() {
        return locador;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public Long getId() {
        return id;
    }

    public Boolean getStatus() {
        return status;
    }
}
