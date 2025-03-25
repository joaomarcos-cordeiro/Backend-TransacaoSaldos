package com.jm.transacao_saldos.controller;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal value, Long payer, Long payee ) {

}
