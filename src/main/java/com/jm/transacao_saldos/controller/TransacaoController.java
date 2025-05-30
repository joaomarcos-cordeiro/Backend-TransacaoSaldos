package com.jm.transacao_saldos.controller;

import com.jm.transacao_saldos.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> realizarTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        transacaoService.transferirValores(transacaoDTO);
        return ResponseEntity.accepted().build();

    }
}
