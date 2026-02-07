package com.sislocacao.core.usecase.locacao;

import com.sislocacao.core.domain.model.Locacao;
import com.sislocacao.core.repository.ILocacaoRepository;
import com.sislocacao.ports.input.BuscarLocacaoPorIdInputPort;

public class BuscarLocacaoPorIdUseCase implements BuscarLocacaoPorIdInputPort {
    private final ILocacaoRepository repository;

    public BuscarLocacaoPorIdUseCase(ILocacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Locacao executar(Long id) {
        return null;
    }
}
