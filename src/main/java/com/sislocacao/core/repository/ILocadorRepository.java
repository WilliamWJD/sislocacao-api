package com.sislocacao.core.repository;

import com.sislocacao.core.domain.model.Locador;

import java.util.Optional;

public interface ILocadorRepository {
    Optional<Locador> buscarLocadorPorId(Long id);
}
