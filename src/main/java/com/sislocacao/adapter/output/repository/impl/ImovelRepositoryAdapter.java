package com.sislocacao.adapter.output.repository.impl;

import com.sislocacao.adapter.output.mapper.ImovelAdapterMapper;
import com.sislocacao.adapter.output.repository.jpa.ImovelJpaRepository;
import com.sislocacao.core.domain.model.Imovel;
import com.sislocacao.core.repository.IImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImovelRepositoryAdapter implements IImovelRepository {

    @Autowired
    private ImovelJpaRepository ImovelJpaRepository;

    @Autowired
    private ImovelAdapterMapper ImovelAdapterMapper;

    @Override
    public Optional<Imovel> buscarImovelPorId(Long id) {
        return ImovelJpaRepository.findById(id)
                .map(ImovelAdapterMapper::paraImovel);
    }
}
