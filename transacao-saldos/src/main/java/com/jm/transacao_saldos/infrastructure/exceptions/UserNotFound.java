package com.jm.transacao_saldos.infrastructure.exceptions;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String mensagem){
        super(mensagem);
    }
}
