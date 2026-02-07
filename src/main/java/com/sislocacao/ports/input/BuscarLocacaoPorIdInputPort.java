package com.sislocacao.ports.input;

import com.sislocacao.core.domain.model.Locacao;

public interface BuscarLocacaoPorIdInputPort {
    Locacao executar(Long id);
}
