package com.sislocacao.adapter.output.repository.jpa.entity;

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
@Table(name = "TB_LOCACOES")
public class LocacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDeInicio;
    private LocalDate dataDeTermino;
    private BigDecimal valorAluguel;

    @ManyToOne
    @JoinColumn(name = "inquilino_id")
    private InquilinoEntity inquilino;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private ImovelEntity imovel;

    @ManyToOne
    @JoinColumn(name = "locador_id")
    private LocadorEntity locador;
}
