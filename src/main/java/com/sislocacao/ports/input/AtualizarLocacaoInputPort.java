package com.sislocacao.ports.input;

import com.sislocacao.core.domain.model.Locacao;
import com.sislocacao.core.usecase.locacao.command.SalvarLocacaoCommand;

public interface AtualizarLocacaoInputPort {
    /**
     * Executar locacao.
     *
     * @param locacaoCommand the locacao command
     * @param idLocacao      the id locacao
     * @return the locacao
     */
    Locacao executar(SalvarLocacaoCommand locacaoCommand, Long idLocacao);
}
