package com.sislocacao.core.usecase.locador;

import com.sislocacao.core.common.DomainComponent;
import com.sislocacao.core.domain.model.Locador;
import com.sislocacao.core.exception.ResourceNotFoundException;
import com.sislocacao.core.repository.ILocadorRepository;
import com.sislocacao.ports.input.BuscarLocadorPorIdInputPort;

@DomainComponent
public class BuscarLocadorPorIdUseCase implements BuscarLocadorPorIdInputPort {
    private final ILocadorRepository locadorRepository;

    public BuscarLocadorPorIdUseCase(ILocadorRepository locadorRepository) {
        this.locadorRepository = locadorRepository;
    }

    @Override
    public Locador execute(Long id) {
        return locadorRepository.buscarLocadorPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Locador não encontrado com id: " + id));
    }
}
