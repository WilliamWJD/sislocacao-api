package com.sislocacao.core.repository;

import com.sislocacao.core.domain.model.Locacao;

public interface ILocacaoRepository {
    Locacao salvarLocacao(Locacao locacao);
}
