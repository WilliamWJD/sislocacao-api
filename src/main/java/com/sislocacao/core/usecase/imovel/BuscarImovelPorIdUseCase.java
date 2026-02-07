package com.sislocacao.core.usecase.imovel;

import com.sislocacao.core.common.DomainComponent;
import com.sislocacao.core.domain.model.Imovel;
import com.sislocacao.core.exception.ResourceNotFoundException;
import com.sislocacao.core.repository.IImovelRepository;
import com.sislocacao.ports.input.BuscarImovelPorIdInputPort;

@DomainComponent
public class BuscarImovelPorIdUseCase implements BuscarImovelPorIdInputPort {

    private final IImovelRepository imovelRepository;

    public BuscarImovelPorIdUseCase(IImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    @Override
    public Imovel execute(Long id) {
        return imovelRepository.buscarImovelPorId(id).orElseThrow(()->{
            throw new ResourceNotFoundException("Imóvel não encontrado para o id: " + id);
        });
    }
}
