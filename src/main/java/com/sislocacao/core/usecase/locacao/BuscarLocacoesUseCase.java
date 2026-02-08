package com.sislocacao.core.usecase.locacao;

import com.sislocacao.core.common.DomainComponent;
import com.sislocacao.core.domain.model.Locacao;
import com.sislocacao.core.repository.ILocacaoRepository;
import com.sislocacao.ports.input.BuscarLocacoesInputPort;

import java.util.List;

@DomainComponent
public class BuscarLocacoesUseCase implements BuscarLocacoesInputPort {

    private final ILocacaoRepository locacaoRepository;

    public BuscarLocacoesUseCase(ILocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    @Override
    public List<Locacao> execute(){
        return locacaoRepository.buscarLocacoes();
    }
}
