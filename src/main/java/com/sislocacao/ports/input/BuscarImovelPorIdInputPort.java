package com.sislocacao.ports.input;

import com.sislocacao.core.domain.model.Imovel;

public interface BuscarImovelPorIdInputPort {
    /**
     * Buscar imovel por id imovel.
     *
     * @param id the id
     * @return the imovel
     */
    Imovel execute(Long id);
}
