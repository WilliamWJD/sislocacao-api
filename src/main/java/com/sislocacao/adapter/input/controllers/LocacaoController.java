package com.sislocacao.adapter.input.controllers;

import com.sislocacao.adapter.input.dto.request.SalvarLocacaoRequest;
import com.sislocacao.adapter.input.dto.response.LocacaoResponse;
import com.sislocacao.adapter.input.mapper.LocacaoMapper;
import com.sislocacao.core.domain.model.Locacao;
import com.sislocacao.core.usecase.locacao.SalvarLocacaoCommand;
import com.sislocacao.ports.input.SalvarLocacaoInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    private final LocacaoMapper locacaoMapper;
    private final SalvarLocacaoInputPort salvarLocacaoInputPort;

    public LocacaoController(LocacaoMapper locacaoMapper, SalvarLocacaoInputPort salvarLocacaoInputPort) {
        this.locacaoMapper = locacaoMapper;
        this.salvarLocacaoInputPort = salvarLocacaoInputPort;
    }

    @PostMapping
    public ResponseEntity<LocacaoResponse> criarLocacao(@RequestBody SalvarLocacaoRequest request){
        SalvarLocacaoCommand command = locacaoMapper.paraSalvarLocacaoCommand(request);
        Locacao locacao = salvarLocacaoInputPort.executar(command);
        LocacaoResponse response = locacaoMapper.paraLocacaoResponse(locacao);
        return ResponseEntity.ok(response);
    }
}
