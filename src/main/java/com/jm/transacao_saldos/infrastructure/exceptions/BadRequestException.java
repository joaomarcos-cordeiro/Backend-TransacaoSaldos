package com.jm.transacao_saldos.infrastructure.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException (String message) {
        super (message);
    }
}
