package com.sislocacao.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_RECIBOS")
public class ReciboEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroRecibo;
    private BigDecimal valorEnergia;
    private BigDecimal valorAgua;
    private BigDecimal valorJuros;
    private BigDecimal valorTotal;
    private String valorTotalPorExtenso;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

    @ManyToOne
    @JoinColumn(name = "locacao_id")
    private LocacaoEntity locacao;
}
