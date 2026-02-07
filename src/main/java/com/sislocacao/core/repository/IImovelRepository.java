package com.sislocacao.core.repository;

import com.sislocacao.core.domain.model.Imovel;

import java.util.Optional;

public interface IImovelRepository {
    Optional<Imovel> buscarImovelPorId(Long id);
}
