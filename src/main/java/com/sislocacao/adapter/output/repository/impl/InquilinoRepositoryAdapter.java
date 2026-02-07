package com.sislocacao.adapter.output.repository.impl;

import com.sislocacao.adapter.output.mapper.InquilinoAdapterMapper;
import com.sislocacao.adapter.output.repository.jpa.InquilinoJpaRepository;
import com.sislocacao.core.domain.model.Inquilino;
import com.sislocacao.core.repository.IInquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InquilinoRepositoryAdapter implements IInquilinoRepository {

    @Autowired
    private InquilinoJpaRepository inquilinoJpaRepository;

    @Autowired
    private InquilinoAdapterMapper inquilinoAdapterMapper;

    @Override
    public Optional<Inquilino> buscarInquilinoPorId(Long id) {
        return inquilinoJpaRepository.findById(id)
                .map(inquilinoAdapterMapper::paraInquilino);
    }
}
