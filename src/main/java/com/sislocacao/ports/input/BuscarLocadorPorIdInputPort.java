package com.sislocacao.ports.input;

import com.sislocacao.core.domain.model.Locador;

public interface BuscarLocadorPorIdInputPort {
    /**
     * Buscar locador por id locador.
     *
     * @param id the id
     * @return the locador
     */
    Locador execute(Long id);
}
