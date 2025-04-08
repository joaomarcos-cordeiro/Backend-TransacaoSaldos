package com.jm.transacao_saldos.service;

import com.jm.transacao_saldos.infrastructure.clients.NotificacaoClient;
import com.jm.transacao_saldos.infrastructure.entity.Usuario;
import com.jm.transacao_saldos.infrastructure.entity.repository.UsuarioRepository;
import com.jm.transacao_saldos.infrastructure.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {
    private final NotificacaoClient client;

    public void enviarNotificacao(){
       client.enviarNotificacao();
    }
}
