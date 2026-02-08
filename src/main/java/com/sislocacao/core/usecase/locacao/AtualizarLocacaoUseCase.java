package com.sislocacao.core.usecase.locacao;

import com.sislocacao.core.domain.model.Imovel;
import com.sislocacao.core.domain.model.Inquilino;
import com.sislocacao.core.domain.model.Locacao;
import com.sislocacao.core.domain.model.Locador;
import com.sislocacao.core.exception.BusinessException;
import com.sislocacao.core.repository.ILocacaoRepository;
import com.sislocacao.core.usecase.locacao.command.SalvarLocacaoCommand;
import com.sislocacao.ports.input.AtualizarLocacaoInputPort;
import com.sislocacao.ports.input.BuscarImovelPorIdInputPort;
import com.sislocacao.ports.input.BuscarInquilinoPorIdInputPort;
import com.sislocacao.ports.input.BuscarLocadorPorIdInputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AtualizarLocacaoUseCase implements AtualizarLocacaoInputPort {

    private final BuscarInquilinoPorIdInputPort buscarInquilinoPorIdInputPort;
    private final BuscarImovelPorIdInputPort buscarImovelPorIdInputPort;
    private final BuscarLocadorPorIdInputPort buscarLocadorPorIdInputPort;
    private final ILocacaoRepository locacaoRepository;

    public AtualizarLocacaoUseCase(BuscarInquilinoPorIdInputPort buscarInquilinoPorIdInputPort, BuscarImovelPorIdInputPort buscarImovelPorIdInputPort, BuscarLocadorPorIdInputPort buscarLocadorPorIdInputPort, ILocacaoRepository locacaoRepository) {
        this.buscarInquilinoPorIdInputPort = buscarInquilinoPorIdInputPort;
        this.buscarImovelPorIdInputPort = buscarImovelPorIdInputPort;
        this.buscarLocadorPorIdInputPort = buscarLocadorPorIdInputPort;
        this.locacaoRepository = locacaoRepository;
    }

    @Override
    public Locacao executar(SalvarLocacaoCommand locacaoCommand, Long idLocacao) {
        Inquilino inquilino = buscarInquilinoPorIdInputPort.executar(locacaoCommand.getIdInquilino());
        Imovel imovel = buscarImovelPorIdInputPort.execute(locacaoCommand.getIdImovel());
        Locador locador = buscarLocadorPorIdInputPort.execute(locacaoCommand.getIdLocador());

        Optional<Locacao> validaLocacao = locacaoRepository
                .buscarLocacaoPorIdImovel(locacaoCommand.getIdImovel());

        if(validaLocacao.isPresent()
                && validaLocacao.get().getStatus() == Boolean.TRUE
                && !validaLocacao.get().getId().equals(idLocacao)){
            throw new BusinessException("O imóvel já possui uma locação ativa.");
        }

        Locacao locacao = atualizarLocacaoFactory(locacaoCommand, inquilino, imovel, locador, idLocacao);
        return locacaoRepository.salvarLocacao(locacao);
    }

    private Locacao atualizarLocacaoFactory(SalvarLocacaoCommand locacaoCommand, Inquilino inquilino, Imovel imovel, Locador locador, long idLocacao) {
        return Locacao.criarLocacao(
                idLocacao,
                locacaoCommand.getDataDeInicio(),
                locacaoCommand.getTempoDeContrato(),
                locacaoCommand.getValorAluguel(),
                inquilino,
                imovel,
                locador
        );
    }
}
