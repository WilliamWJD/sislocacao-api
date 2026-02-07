package com.sislocacao.core.usecase.locacao;

import com.sislocacao.core.domain.model.Imovel;
import com.sislocacao.core.domain.model.Inquilino;
import com.sislocacao.core.domain.model.Locacao;
import com.sislocacao.core.domain.model.Locador;
import com.sislocacao.core.exception.BusinessException;
import com.sislocacao.core.repository.IImovelRepository;
import com.sislocacao.core.repository.ILocacaoRepository;
import com.sislocacao.ports.input.BuscarImovelPorIdInputPort;
import com.sislocacao.ports.input.BuscarInquilinoPorIdInputPort;
import com.sislocacao.ports.input.BuscarLocadorPorIdInputPort;
import com.sislocacao.ports.input.SalvarLocacaoInputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalvarLocacaoUseCase implements SalvarLocacaoInputPort {

    private final BuscarInquilinoPorIdInputPort buscarInquilinoPorIdInputPort;
    private final BuscarImovelPorIdInputPort buscarImovelPorIdInputPort;
    private final BuscarLocadorPorIdInputPort buscarLocadorPorIdInputPort;
    private final ILocacaoRepository locacaoRepository;
    private final IImovelRepository imovelRepository;

    public SalvarLocacaoUseCase(BuscarInquilinoPorIdInputPort buscarInquilinoPorIdInputPort, BuscarImovelPorIdInputPort buscarImovelPorIdInputPort, BuscarLocadorPorIdInputPort buscarLocadorPorIdInputPort, ILocacaoRepository locacaoRepository, IImovelRepository imovelRepository) {
        this.buscarInquilinoPorIdInputPort = buscarInquilinoPorIdInputPort;
        this.buscarImovelPorIdInputPort = buscarImovelPorIdInputPort;
        this.buscarLocadorPorIdInputPort = buscarLocadorPorIdInputPort;
        this.locacaoRepository = locacaoRepository;
        this.imovelRepository = imovelRepository;
    }

    @Override
    public Locacao executar(SalvarLocacaoCommand locacaoCommand) {
        Inquilino inquilino = buscarInquilinoPorIdInputPort.executar(locacaoCommand.getIdInquilino());
        Imovel imovel = buscarImovelPorIdInputPort.execute(locacaoCommand.getIdImovel());
        Locador locador = buscarLocadorPorIdInputPort.execute(locacaoCommand.getIdLocador());

        Optional<Locacao> validaLocacao = locacaoRepository
                .buscarLocacaoPorIdImovel(locacaoCommand.getIdImovel());

        if(validaLocacao.isPresent() && validaLocacao.get().getStatus() == Boolean.TRUE){
            throw new BusinessException("O imóvel já possui uma locação ativa.");
        }

        Locacao locacao = criarLocacaoFactory(locacaoCommand, inquilino, imovel, locador);
        return locacaoRepository.salvarLocacao(locacao);
    }

    private Locacao criarLocacaoFactory(SalvarLocacaoCommand locacaoCommand, Inquilino inquilino, Imovel imovel, Locador locador) {
        return Locacao.criarLocacao(
                locacaoCommand.getDataDeInicio(),
                locacaoCommand.getTempoDeContrato(),
                locacaoCommand.getValorAluguel(),
                inquilino,
                imovel,
                locador
        );
    }
}
