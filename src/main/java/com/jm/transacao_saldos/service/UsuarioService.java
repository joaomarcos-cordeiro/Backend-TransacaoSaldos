package com.jm.transacao_saldos.service;

import com.jm.transacao_saldos.infrastructure.entity.Usuario;
import com.jm.transacao_saldos.infrastructure.entity.repository.UsuarioRepository;
import com.jm.transacao_saldos.infrastructure.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    public Usuario buscarUsuario(Long id){
        return repository.findById(id).
                orElseThrow(() ->
                        new UserNotFound("Usuário não encontrado"));
    }
}
