package com.sislocacao.ports.input;

import com.sislocacao.core.domain.model.Locacao;

import java.util.List;

public interface BuscarLocacoesInputPort {
    /**
     * Execute list.
     *
     * @return the list
     */
    List<Locacao> execute();
}
