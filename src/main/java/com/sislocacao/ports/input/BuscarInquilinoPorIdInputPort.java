package com.sislocacao.ports.input;

import com.sislocacao.core.domain.model.Inquilino;

public interface BuscarInquilinoPorIdInputPort {
    /**
     * Executar inquilino.
     *
     * @param id the id
     * @return the inquilino
     */
    Inquilino executar(Long id);
}
