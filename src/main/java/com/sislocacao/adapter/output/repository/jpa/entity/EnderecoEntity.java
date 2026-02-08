package com.sislocacao.adapter.output.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ENDERECOS")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String estado;
    private String bairro;
    private String cidade;
    private String cep;
}
