package com.sislocacao.core.repository;

import com.sislocacao.core.domain.model.Inquilino;

import java.util.Optional;

public interface IInquilinoRepository {
    Optional<Inquilino> buscarInquilinoPorId(Long id);
}
