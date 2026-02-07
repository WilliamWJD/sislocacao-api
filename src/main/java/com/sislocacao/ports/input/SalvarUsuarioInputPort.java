package com.sislocacao.ports.input;

import com.sislocacao.core.domain.model.Usuario;

/**
 * The interface Salvar usuario input port.
 */
public interface SalvarUsuarioInputPort {
    Usuario executar(Usuario usuario);
}
