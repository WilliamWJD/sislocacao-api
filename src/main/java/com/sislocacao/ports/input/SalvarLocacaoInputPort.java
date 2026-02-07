package com.sislocacao.ports.input;

import com.sislocacao.core.domain.model.Locacao;
import com.sislocacao.core.usecase.locacao.SalvarLocacaoCommand;

public interface SalvarLocacaoInputPort {
    /**
     * Executar locacao.
     *
     * @param locacao the locacao
     * @return the locacao
     */
    Locacao executar(SalvarLocacaoCommand locacao);
}
