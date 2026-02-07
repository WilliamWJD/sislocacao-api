package com.sislocacao.adapter.output.repository.impl;

import com.sislocacao.adapter.output.mapper.LocacaoAdapterMapper;
import com.sislocacao.adapter.output.repository.jpa.LocacaoJpaRepository;
import com.sislocacao.adapter.output.repository.jpa.entity.LocacaoEntity;
import com.sislocacao.core.domain.model.Locacao;
import com.sislocacao.core.repository.ILocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocacaoRepositoryAdapter implements ILocacaoRepository {

    @Autowired
    private LocacaoJpaRepository locacaoJpaRepository;

    @Autowired
    private LocacaoAdapterMapper locacaoAdapterMapper;

    @Override
    public Locacao salvarLocacao(Locacao locacao) {
        LocacaoEntity locacaoEntity = locacaoAdapterMapper.paraLocacaoEntity(locacao);
        return locacaoAdapterMapper.paraLocacao(locacaoJpaRepository.save(locacaoEntity));
    }
}
