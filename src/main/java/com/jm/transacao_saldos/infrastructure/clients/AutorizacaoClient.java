package com.jm.transacao_saldos.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.cloud.openfeign.FeignClient;
@FeignClient(url = "https://util.devi.tools/api/v2/authorize", name = "autorizacao")

public interface AutorizacaoClient {

    @GetMapping
    AutorizacaoDTO validarAutorizacao();

}
