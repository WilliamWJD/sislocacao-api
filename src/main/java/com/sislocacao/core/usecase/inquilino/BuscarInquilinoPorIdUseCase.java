package com.sislocacao.core.usecase.inquilino;

import com.sislocacao.core.common.DomainComponent;
import com.sislocacao.core.domain.model.Inquilino;
import com.sislocacao.core.exception.ResourceNotFoundException;
import com.sislocacao.core.repository.IInquilinoRepository;
import com.sislocacao.ports.input.BuscarInquilinoPorIdInputPort;

@DomainComponent
public class BuscarInquilinoPorIdUseCase implements BuscarInquilinoPorIdInputPort {

    private final IInquilinoRepository inquilinoRepository;

    public BuscarInquilinoPorIdUseCase(IInquilinoRepository inquilinoRepository) {
        this.inquilinoRepository = inquilinoRepository;
    }

    @Override
    public Inquilino executar(Long id){
        return inquilinoRepository.buscarInquilinoPorId(id)
                .orElseThrow( ()-> new ResourceNotFoundException("Inquilino não encontrado para o id: " + id));
    }
}
