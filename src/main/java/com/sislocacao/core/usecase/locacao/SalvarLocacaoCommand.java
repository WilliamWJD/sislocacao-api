package com.sislocacao.core.usecase.locacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalvarLocacaoCommand {
    private LocalDate dataDeInicio;
    private Integer tempoDeContrato;
    private BigDecimal valorAluguel;
    private Long idInquilino;
    private Long idImovel;
    private Long idLocador;

    public SalvarLocacaoCommand(LocalDate dataDeInicio, Integer tempoDeContrato, BigDecimal valorAluguel, Long idInquilino, Long idImovel, Long idLocador) {
        this.dataDeInicio = dataDeInicio;
        this.tempoDeContrato = tempoDeContrato;
        this.valorAluguel = valorAluguel;
        this.idInquilino = idInquilino;
        this.idImovel = idImovel;
        this.idLocador = idLocador;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public Integer getTempoDeContrato() {
        return tempoDeContrato;
    }

    public void setTempoDeContrato(Integer tempoDeContrato) {
        this.tempoDeContrato = tempoDeContrato;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Long getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(Long idInquilino) {
        this.idInquilino = idInquilino;
    }

    public Long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Long idImovel) {
        this.idImovel = idImovel;
    }

    public Long getIdLocador() {
        return idLocador;
    }

    public void setIdLocador(Long idLocador) {
        this.idLocador = idLocador;
    }
}
