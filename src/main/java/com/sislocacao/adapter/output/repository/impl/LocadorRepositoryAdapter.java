package com.sislocacao.adapter.output.repository.impl;

import com.sislocacao.adapter.output.mapper.LocadorAdapterMapper;
import com.sislocacao.adapter.output.repository.jpa.LocadorJpaRepository;
import com.sislocacao.core.domain.model.Locador;
import com.sislocacao.core.repository.ILocadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LocadorRepositoryAdapter implements ILocadorRepository {

    @Autowired
    private LocadorJpaRepository LocadorJpaRepository;

    @Autowired
    private LocadorAdapterMapper LocadorAdapterMapper;

    @Override
    public Optional<Locador> buscarLocadorPorId(Long id) {
        return LocadorJpaRepository.findById(id)
                .map(LocadorAdapterMapper::paraLocador);
    }
}
